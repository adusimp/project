<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
    <?php
        $product_description = filter_input(INPUT_POST,'product_description');
        $list_price = filter_input(INPUT_POST,'list_price');
        $discount_percent = filter_input(INPUT_POST,'discount_percent');
        $discount_amount = $list_price*$discount_percent*.01;
        $discount_price = $list_price-$discount_amount;

        $discount_amount_display = "$".$discount_amount;
        $discount_price_display = "$".$discount_price;
        $list_price_display = "$".$list_price;
        $discount_percent_display = $discount_percent."%";
    ?>
    <main>
        <h1>This page is under construction</h1>

        <label>Product Description:</label>
        <span><?php echo htmlspecialchars($product_description); ?></span><br>

        <label>List Price:</label>
        <span><?php echo htmlspecialchars($list_price_display); ?></span><br>

        <label>Standard Discount:</label>
        <span><?php echo htmlspecialchars($discount_percent_display); ?></span><br>

        <label>Discount Amount:</label>
        <span><?php echo htmlspecialchars($discount_amount_display); ?></span><br>

        <label>Discount Price:</label>
        <span><?php echo htmlspecialchars($discount_price_display); ?></span><br>
    </main>
</body>
</html>