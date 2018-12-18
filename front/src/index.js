fetch('http://localhost:8081/randG')
  .then(res => res.json())
  .then(json => {
    console.log(json);
  });

fetch('http://localhost:8081/randP', {
  body: JSON.stringify(10),
  headers: {
    'Content-Type': 'application/json',
  },
  method: 'POST',
}).then(res => res.json())
  .then(json => {
    console.log(json);
  });

document.cookie = 'hoge=100';

fetch('http://localhost:8081/randC', {
  mode: 'cors',
  credentials: 'include',
}).then(res => res.json())
  .then(json => {
    console.log(json);
  });
