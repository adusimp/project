<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Xuất số thành chữ</title>
</head>
<body>
<?php
    if(is_numeric($_POST["so"])){
        switch($_POST["so"]){
            case 0: $chu="khong";break;
            case 1: $chu="mot";break;
            case 2: $chu="hai";break;
            case 3: $chu="ba";break;
            case 4: $chu="bon";break;
            case 5: $chu="nam";break;
            case 6: $chu="sau";break;
            case 7: $chu="bay";break;
            case 8: $chu="tam";break;
            case 9: $chu="chin";break;
        }
    }
?>
<form action="bai3.php" method="POST" >
<table width="519" border="1">
<tr>
<td colspan="3">Đọc số</td>
</tr>
<tr>
<td>Nhập số (0-9)</td>
<td width="69" rowspan="2"><input type="submit" name="button" id="button" 
value="Submit" /></td>
<td> Bằng chữ</td>
</tr>
<tr>
<td width="177"><p>
<label for="textfield"></label>
<input type="text" name="so" id="textfield" value="<?php echo $_POST["so"] ?>" />
</p></td>
<td width="232"><label for="textfield2"></label>
<input type="text" name="chu" id="textfield2" value="<?php echo $chu ?>"/></td>
</tr>
</table>
</form>
</body>
</html