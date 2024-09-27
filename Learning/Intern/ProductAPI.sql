use ProductAPI;
#Categories
INSERT INTO Categories (name) VALUES
( 'Home & Decor'),
( 'Clothing'),
( 'Accessories'),
( 'Outdoor');
#Promotion
INSERT INTO Promotions ( name, discount) VALUES
( 'Holiday Sale', 10),
( 'Clearance Sale', 20),
( 'New Year Special', 15);


#Size
INSERT INTO Sizes ( name) VALUES
( 'Small'),
( 'Medium'),
( 'Large');
#Style
INSERT INTO Styles ( name) VALUES
( 'Modern'),
( 'Streetwear'),
( 'Colorful');
#Color
INSERT INTO Colors ( name) VALUES
('Red'),
( 'Blue'),
( 'Black');
#Product
INSERT INTO Products (category_id, promotion_id, `name`, price, rating, `description`, image_url,quantity, review_quantity, is_deleted) VALUES
(1, 2, 'Coffee Table', 15000, 5, 'Modern wooden coffee table for home decor', '/images/coffeetable.png', 10,40, 0),
(1, 1, 'Floor Lamp', 8000, 4, 'Elegant floor lamp with adjustable brightness', '/images/floorlamp.png', 10,25, 0),
(2, 3, 'Leather Jacket', 25000, 5, 'Stylish leather jacket for outdoor adventures', '/images/leatherjacket.png', 10,60, 0),
(3, 1, 'Watch', 5000, 4, 'Analog wristwatch with water-resistant features', '/images/watch.png', 10,80, 0),
(4, 2, 'Tent', 30000, 4, 'Waterproof camping tent for 4 people', '/images/tent.png', 10,35, 0),
(4, 1, 'Hiking Boots', 12000, 5, 'Durable hiking boots with non-slip sole', '/images/hikingboots.png', 10,70, 0),
(3, 3, 'Sunglasses', 1000, 3, 'Fashionable sunglasses with UV protection', '/images/sunglasses.png', 10,45, 0),
(2, 2, 'Jeans', 3000, 4, 'Comfortable blue jeans', '/images/jeans.png', 10,55, 0);
#Size_Product
INSERT INTO Product_Sizes (product_id, size_id) VALUES
(1, 2),
(2, 3),
(3, 1);


#Style_Product
INSERT INTO Product_Styles (product_id, style_id) VALUES
(1, 1),
(2, 3),
(3, 2);

#Color_Product
INSERT INTO Product_Colors (product_id, color_id) VALUES
(1, 3),
(2, 1),
(3, 2);





