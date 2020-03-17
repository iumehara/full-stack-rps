import React from 'react';
import {fireEvent, render} from '@testing-library/react';
import App from './App';
import {waitForElement} from '@testing-library/dom'

describe('Janken App', () => {
  it('displays title', () => {
    const {getByText} = render(<App/>);


    const title = getByText(/Janken/i);


    expect(title).toBeInTheDocument();
  })

  it('submits input to repo', async () => {
    let createCalledWith
    const repoSpy = {
      create(p1, p2) {
        createCalledWith = {p1, p2}
        return Promise.resolve({outcome: 'P1_WINS'})
      }
    }
    const app = render(<App repo={repoSpy}/>)


    const p1Input = app.getByLabelText('Player 1')
    fireEvent.change(p1Input, {target: {value: 'ROCK'}})
    const p2Input = app.getByLabelText('Player 2')
    fireEvent.change(p2Input, {target: {value: 'PAPER'}})
    const submitButton = app.getByText('Submit')
    fireEvent.click(submitButton)


    await waitForElement(() => createCalledWith != undefined)
    expect(createCalledWith.p1).toEqual('ROCK')
    expect(createCalledWith.p2).toEqual('PAPER')
  })

  it('displays response from repo', async () => {
    const repoStub = {
      create(p1, p2) {
        return Promise.resolve({outcome: 'P1_WINS'})
      }
    }
    const app = render(<App repo={repoStub}/>)


    const submitButton = app.getByText('Submit')
    fireEvent.click(submitButton)


    await waitForElement(() => app.getByText('P1_WINS'))
    expect(app.getByText('P1_WINS')).toBeInTheDocument()
  })
});
