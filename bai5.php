<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Untitled Document</title>
</head>

<body>
    <?php
    $a = $_POST["a"];
    $b = $_POST["b"];
    $c = $_POST["c"];
    if ($a == 0) {
        if ($b == 0 && $c == 0)
            $nghiem = "pt co vo so nghiem";
        else if ($b == 0 && $c != 0)
            $nghiem = "pt vo nghiem";
        else if ($b != 0)
            $nghiem = -$c / $b;
    } else {
        $delta = $b * $b - 4 * $a * $c;
        if ($delta == 0)
            $nghiem = -$b / (2 * $a);
        else if ($delta > 0) {
            $x1 = (-$b - sqrt($delta)) / (4 * $a);
            $x2 = (-$b + sqrt($delta)) / (4 * $a);
            $nghiem = "x1=" . $x1 . " x2=" . $x2;
        }
        else {
            $nghiem = "pt ko co nghiem thuc";
        }
    }

    ?>
    <form action="bai5.php" method="post">
        <table width="806" border="1">
            <tr>
                <td colspan="4" bgcolor="#336699"><strong>Giải phương trình bậc 2</strong></td>
            </tr>
            <tr>
                <td width="83">Phương trình </td>
                <td width="236">
                    <input name="a" type="text" />
                    X^2 +
                </td>
                <td width="218"><label for="textfield3"></label>
                    <input type="text" name="b" id="textfield3" />
                    X+
                </td>
                <td width="241"><label for="textfield"></label>
                    <input type="text" name="c" id="textfield" />
                    =0
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    Nghiệm
                    <label for="textfield2"></label>
                    <input name="textfield" type="text" id="textfield2" width="400" value="<?php echo $nghiem ?>" />
            </tr>
            <tr>
                <td colspan="4" align="center" valign="middle"><input type="submit" name="chao" id="chao"
                        value="Xuất" /></td>
            </tr>
        </table>
    </form>
</body>

</html>