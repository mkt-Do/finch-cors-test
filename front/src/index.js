fetch('http://localhost:8081/randG')
  .then(res => res.json())
  .then(json => {
    console.log(json);
  });
