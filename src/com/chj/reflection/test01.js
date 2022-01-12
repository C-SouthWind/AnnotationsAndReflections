function f() {
    var x = "var a = 3; var b = 4; alert(a+b)";
    eval(x);//可以将本来是字符串的x执行 变成代码
}