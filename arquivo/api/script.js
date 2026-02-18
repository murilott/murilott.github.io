function getAPI(id) {
  if (id == "1") {
    fetch('https://nekos.best/api/v2/neko')
    .then(response => response.json())
    .then(json => exibir_imagem(json.results[0].url, id))
  } 
  if (id == "2") {
    fetch('https://dog.ceo/api/breeds/image/random')
    .then(response => response.json())
    .then(data => exibir_imagem(data.message, id));
  }
}

function exibir_imagem(data, id){
  var elementId = "imgID" + id
  console.log(elementId)
  console.log(data)
  document.getElementById(elementId).src = data;
}

/*
function getAPI() {

  fetch('https://nekos.best/api/v2/neko')
    .then(response => response.json())
    //.then(json => console.log(json.results[0].url))
    //.then(response => JSON.stringify(response))
    //.then(json => exibir_imagem(response))
    .then(json => exibir_imagem(json.results[0].url))
} 

function getAPI2() {

  fetch('https://dog.ceo/api/breeds/image/random')
    .then(response => response.json())
    //.then(json => console.log(json.results[0].url))
    //.then(response => JSON.stringify(response))
    //.then(json => exibir_imagem(response))
    .then(data => exibir_imagem2(data));
} 

function exibir_imagem(data){
    document.getElementById("imgID").src = data;
}

function exibir_imagem2(data){
    document.getElementById("imgID2").src = data.message;
}

*/