function hex_from_chars(inputstr) {
    var delimiter = '';
    var outputstr = '';
    var hex = "0123456789abcdef";
    hex = hex.split('');
    var i, n;
    var inputarr = inputstr.split('');
    for(var i=0; i<inputarr.length; i++) {
        if(i > 0) outputstr += delimiter;
        if(!delimiter && i % 32 == 0 && i > 0) outputstr += '\n';
        n = inputstr.charCodeAt(i);
        outputstr += hex[(n >> 4) & 0xf] + hex[n & 0xf];
    }
    return outputstr;
}