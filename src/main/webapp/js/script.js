function formcheck() {
  var url = "formcheckservlet";
  var userid = document.getElementById("userid").value;
  var userpwd = document.getElementById("userpwd").value;
  var params = "userid=" + userid + "&userpwd" + userpwd;
  sendRequest(url, params, 'POST', showresult);
}

function showresult() {
  if (httpRequest.readyState == 4) {
    if (httpRequest.status == 200) {
      var info = httpRequest.responseText;
      document.getElementById("result").innerHTML = info;
    }
  }
}