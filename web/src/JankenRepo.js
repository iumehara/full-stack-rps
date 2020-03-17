export default class JankenRepo {
  constructor(fetcher) {
    this.fetcher = fetcher
  }

  create(p1, p2) {
    return this.fetcher.postJson('http://localhost:8080/match-results', {p1, p2})
  }
}
