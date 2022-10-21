function checkform(f) {
  var errMSG = "";
  for (var i = 0; i < f.elements.length; i++){
    if (null != f.elements[i].getAttribute("required"))
        if (isEmpty(f.elements[i].value)) {
            errMSG += "  " + f.elements[i].name + "\n";
        }
        if ("" != errMSG) {
            alert("Не заполнены обязательные поля:\n" + errMSG);
            return false;
        }
  }
}
