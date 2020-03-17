import JankenRepo from './JankenRepo'

describe('JankenRepo', () => {
  it('works', () => {
    let postJsonCalledWith = {}
    const fetcherSpy = {
      postJson: (url, body) => {
        postJsonCalledWith.url = url
        postJsonCalledWith.p1 = body.p1
        postJsonCalledWith.p2 = body.p2
      }
    }
    const jankenRepo = new JankenRepo(fetcherSpy)

    jankenRepo.create('ROCK', 'PAPER')

    expect(postJsonCalledWith.url).toBe('http://localhost:8080/match-results')
    expect(postJsonCalledWith.p1).toBe('ROCK')
    expect(postJsonCalledWith.p2).toBe('PAPER')
  })
})