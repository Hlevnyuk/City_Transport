const routeInBtn = document.querySelector('.route-btn');
const stopInBtn = document.querySelector('.stop-btn');
const formBox = document.querySelector('.form-box');
const body = document.body;
stopInBtn.addEventListener('click', function() {
    formBox.classList.add('active');
    body.classList.add('active');
});
routeInBtn.addEventListener('click', function() {
    formBox.classList.remove('active');
    body.classList.remove('active');
});
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}
function filterFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
      txtValue = a[i].textContent || a[i].innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        a[i].style.display = "";
      } else {
        a[i].style.display = "none";
      }
    }
}
function inputFunction(stopId) {
    var input;
    input = document.getElementById("myInput");
    input.setAttribute("value", stopId);
}