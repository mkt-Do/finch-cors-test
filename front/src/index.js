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
