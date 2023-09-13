<?php 
    require_once('database.php');
    
    $category_name= filter_input(INPUT_POST,'category_name');
    $query = 'INSERT INTO categories(categoryName) values(:category_name)';
    $statement = $db->prepare($query);
    $statement->bindValue(':category_name',$category_name);
    $statement->execute();
    $statement->closeCursor();

    include('category_list.php');
?>