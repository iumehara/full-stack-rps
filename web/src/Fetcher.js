export default class Fetcher {
  headers = {
    'Accept': 'application/json',
    'Origin': 'http://localhost:3000'
  }

  postJson(url, rawBody) {
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        'Origin': window.location.href
      },
      body: JSON.stringify(rawBody)
    }

    return fetch(url, options)
      .then(response => response.json())
  }
}