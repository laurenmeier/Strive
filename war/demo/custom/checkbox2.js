function checkbox2( containerId, settings, fieldDef ) {
  this.container =  $('#' + containerId);
  
  var that = this;
  
  function onClick(evt) {
     value = that.getValue();
     if(value === true)
       value = false;
     else 
       value = true;
     that.setValue( value );
    that.listener(evt, that, value );
  }
  
  this.render = function(onReady) {
    this.container.empty();
    this.container.append($("<img src='/demo/custom/none.png' style='height:20px;cursor: pointer;'/>"));
    this.container.find("img").click( onClick );
    onReady(this);
  }
  
  this.getValue = function() {
    var img = this.container.find("img");
    if(img.prop("src").indexOf("true") >0)
      return true;
    else if(img.prop("src").indexOf("false") >0)
      return false;
    else 
      return undefined;
  }
  
  this.setValue = function( value ) {
    var image = "false";
    if(value === undefined)
      image = "none";
    else if(value === true)
      image = "true";

    var src = "/demo/custom/" + image + ".png";
    this.container.find("img").prop("src", src);
  }
  
  this.change = function(listener) {
    this.listener = listener;
  }
  
  this.setDisabled = function(state) {
    if(state) {
      this.container.find("img").unbind( "click" );
      this.container.find("img").css("cursor", "");
    }
    else {
      this.container.find("img").click( onClick );
      this.container.find("img").css("cursor", "pointer");
    }
  }
}