import React, {useState} from 'react';
import './App.css';

function App(props) {
  const [p1, setP1] = useState('')
  const [p2, setP2] = useState('')
  const [outcome, setOutcome] = useState('No Outcome')

  const submitClicked = () => {
    props.repo.create(p1, p2)
      .then(response => {
        setOutcome(response.outcome)
      })
  }

  return (
    <div className="App">
      <div className='App-header'>Janken</div>
      <div className='content'>
        <div>
          <label htmlFor='p1-input'>Player 1</label>
          <input id='p1-input' onChange={e => setP1(e.target.value)}/>
        </div>
        <div>
          <label htmlFor='p2-input'>Player 2</label>
          <input id='p2-input' onChange={e => setP2(e.target.value)}/>
        </div>
        <button onClick={() => submitClicked()}>Submit</button>
        <div>
          <div>OUTCOME</div>
          <div>{outcome}</div>
        </div>
      </div>
    </div>
  );
}

export default App;
