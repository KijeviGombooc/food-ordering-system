-- Inserting Customers with Explicit IDs
INSERT INTO customer (id, email, name) VALUES
(1, 'john.doe@example.com', 'John Doe'),
(2, 'jane.smith@example.com', 'Jane Smith');

-- Inserting Restaurants with Explicit IDs
INSERT INTO restaurant (id, name) VALUES
(1, 'Pasta Palace'),
(2, 'Burger Bistro');

-- Inserting Items with Explicit IDs
-- Items for Pasta Palace (Restaurant ID 1)
INSERT INTO item (id, price, restaurant_id, description, name) VALUES
(1, 12.99, 1, 'Delicious spaghetti with marinara sauce', 'Spaghetti Marinara'),
(2, 14.99, 1, 'Creamy fettuccine alfredo', 'Fettuccine Alfredo'),
(3, 9.99, 1, 'Fresh Caesar salad', 'Caesar Salad');

-- Items for Burger Bistro (Restaurant ID 2)
INSERT INTO item (id, price, restaurant_id, description, name) VALUES
(4, 10.99, 2, 'Juicy cheeseburger with lettuce and tomato', 'Cheeseburger'),
(5, 11.99, 2, 'Crispy chicken sandwich with mayo', 'Chicken Sandwich'),
(6, 8.99, 2, 'Classic fries with a side of ketchup', 'French Fries');
