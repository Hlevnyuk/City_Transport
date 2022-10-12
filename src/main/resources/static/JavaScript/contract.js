//function checkdate(){
//    var dateReg = /^\d{2}([./-])\d{2}\1\d{4}$/ //MM-DD-YYYY format
//    var date = document.getElementById("date");
//    if(!date.value.match(dateReg)){
//    	alert("not a date ");
//    	return false;
//
//    } else{
//      const date1 = new Date(date.value);
//      const date2 = new Date();
//      const diffTime = (date2 - date1);
//      const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
//      if(diffDays > 0){
//          alert("contract expired");
//      }else{
//        alert("contract valid");
//      }
//    }
//    return true;
//}
//function handler(event) {
//  function str(el) {
//    if (!el) return "null"
//    return el.className || el.tagName;
//  }
//  log.value += event.type + ':  ' +
//    'target=' + str(event.target) +
//    ',  relatedTarget=' + str(event.relatedTarget) + "\n";
//  log.scrollTop = log.scrollHeight;
//  if (event.type == 'mouseover') {
//    event.target.style.background = 'pink'
//  }
//  if (event.type == 'mouseout') {
//    event.target.style.background = ''
//  }
//}
first.addEventListener("load", function checkDate() {
    var today = new Date();
    var date = document.getElementById("date");
    if(date > today) {
        alert("Термін договору вийшов");
        return false;
    }
    return true
});