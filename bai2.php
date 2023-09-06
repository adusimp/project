<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php
        $a= $_POST["a"];
        $b= $_POST["b"];
        $n="";
        if($a==0){
            if($b==0)
                $n="vo so nghiem";
            else
                $n="vo nghiem";
        }
        else {
            $n= number_format(-$b/$a,2);
        }
    ?>
    <form action="bai2.php" method="post">
        <table>
            <tr>
                <td>Giải pt bac 1</td>
            </tr>
            <tr>
                <td>phuong trinh <input type="text" name="a"/>x +<input type="text" name="b"/>= 0</td>
            </tr>
            <tr>
                <td><label for="">Nghiem x = <?php if(isset($n)) echo $n; ?></label> </td>
            </tr>
            <tr>
                <td><input type="submit" value ="xuat"/></td>
            </tr>
        </table>
    </form>
    
</body>
</html>