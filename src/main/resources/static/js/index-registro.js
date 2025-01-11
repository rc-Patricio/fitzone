let iniciasecion = document.querySelector('.iniciasecion');
let crearcuenta = document.querySelector('.crearcuenta');
let  container = document.querySelector('.container');

iniciasecion.onclick = function(){
  container.classList.add('iniciacardform')
}
crearcuenta.onclick = function(){
 container.classList.remove('iniciacardform')
}



