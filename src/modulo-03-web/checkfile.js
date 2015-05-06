function checkFile() {
    var fileElement = document.getElementById("img");
    var fileExtension = "";
    if (fileElement.value.lastIndexOf(".") > 0) {
        fileExtension = fileElement.value.substring(fileElement.value.lastIndexOf(".") + 1, fileElement.value.length);
    }
    if (fileExtension == "png" || fileExtension == "jpg") {
        return true;
    }
    else {
        alert("A imagem deve ser .PNG ou .JPG");
        return false;
    }
}