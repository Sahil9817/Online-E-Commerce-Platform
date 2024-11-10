CREATE DATABASE codemart;

USE codemart;

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    password_hash VARCHAR(255),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(20),
    phone_number VARCHAR(20)
);

CREATE TABLE Products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description TEXT,
    price DECIMAL(10,2),
    category_id INT,
    image_url VARCHAR(255),
    stock_quantity INT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

CREATE TABLE Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    order_date DATETIME,
    total_amount DECIMAL(10,2),
    status ENUM('pending', 'processing', 'shipped', 'delivered', 'canceled'),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Order_Items (
    order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    product_id INT,
    quantity INT,
    price DECIMAL(10,2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Cart (
    cart_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Contact_Form_Entries (
    entry_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    message TEXT,
    created_date DATETIME
);

CREATE TABLE Newsletter_Subscribers (
    subscriber_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE,
    subscribed_date DATETIME
);

CREATE TABLE Blog_Posts (
    post_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    content TEXT,
    author_id INT,
    published_date DATETIME,
    category_id INT,
    FOREIGN KEY (author_id) REFERENCES Users(user_id),
    FOREIGN KEY (category_id) REFERENCES Blog_Categories(category_id)
);

CREATE TABLE Blog_Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE Reviews (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    user_id INT,
    rating INT,
    comment TEXT,
    created_date DATETIME,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Wishlist (
    wishlist_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    product_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Coupons (
    coupon_id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    discount_amount DECIMAL(10,2),
    discount_type ENUM('fixed', 'percentage'),
    expiry_date DATE
);

CREATE TABLE Shipping_Addresses (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(20),
    phone_number VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE DATABASE codemart;

USE codemart;

CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    password_hash VARCHAR(255),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(20),
    phone_number VARCHAR(20)
);

CREATE TABLE Products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description TEXT,
    price DECIMAL(10,2),
    category_id INT,
    image_url VARCHAR(255),
    stock_quantity INT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

CREATE TABLE Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    order_date DATETIME,
    total_amount DECIMAL(10,2),
    status ENUM('pending', 'processing', 'shipped', 'delivered', 'canceled'),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Order_Items (
    order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    product_id INT,
    quantity INT,
    price DECIMAL(10,2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Cart (
    cart_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Contact_Form_Entries (
    entry_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    message TEXT,
    created_date DATETIME
);

CREATE TABLE Newsletter_Subscribers (
    subscriber_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE,
    subscribed_date DATETIME
);

CREATE TABLE Blog_Posts (
    post_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    content TEXT,
    author_id INT,
    published_date DATETIME,
    category_id INT,
    FOREIGN KEY (author_id) REFERENCES Users(user_id),
    FOREIGN KEY (category_id) REFERENCES Blog_Categories(category_id)
);

CREATE TABLE Blog_Categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE Reviews (
    review_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    user_id INT,
    rating INT,
    comment TEXT,
    created_date DATETIME,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

CREATE TABLE Wishlist (
    wishlist_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    product_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Coupons (
    coupon_id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(50) UNIQUE,
    discount_amount DECIMAL(10,2),
    discount_type ENUM('fixed', 'percentage'),
    expiry_date DATE
);

CREATE TABLE Shipping_Addresses (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(20),
    phone_number VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);
CREATE TABLE Product_Images (
    product_id INT,
    image_url VARCHAR(255),
    PRIMARY KEY (product_id, image_url),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Product_Variants (
    variant_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    size VARCHAR(20),
    color VARCHAR(20),
    price DECIMAL(10,2),
    stock_quantity INT,
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Payment_Methods (
    payment_method_id INT PRIMARY KEY AUTO_INCREMENT,
    method_name VARCHAR(50)
);

CREATE TABLE Delivery_Options (
    delivery_option_id INT PRIMARY KEY AUTO_INCREMENT,
    option_name VARCHAR(50),
    estimated_delivery_time INT,
    cost DECIMAL(10,2)
);

CREATE TABLE Returns (
    return_id INT PRIMARY KEY AUTO_INCREMENT,
    order_item_id INT,
    return_date DATETIME,
    reason TEXT,
    status ENUM('pending', 'approved', 'rejected', 'processed'),
    FOREIGN KEY (order_item_id) REFERENCES Order_Items(order_item_id)
);

CREATE TABLE Refunds (
    refund_id INT PRIMARY KEY AUTO_INCREMENT,
    return_id INT,
    amount DECIMAL(10,2),
    refund_date DATETIME,
    method VARCHAR(50),
    FOREIGN KEY (return_id) REFERENCES Returns(return_id)
);

CREATE TABLE Order_Tracking (
    order_id INT,
    tracking_number VARCHAR(50),
    carrier VARCHAR(50),
    status VARCHAR(50),
    PRIMARY KEY (order_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);

CREATE TABLE About_Us (
    about_us_id INT PRIMARY KEY,
    content TEXT
);

CREATE TABLE Terms_and_Conditions (
    terms_and_conditions_id INT PRIMARY KEY,
    content TEXT
);

CREATE TABLE Privacy_Policy (
    privacy_policy_id INT PRIMARY KEY,
    content TEXT
);

CREATE TABLE FAQ (
    faq_id INT PRIMARY KEY AUTO_INCREMENT,
    question TEXT,
    answer TEXT
);

CREATE TABLE Social_Media_Links (
    link_id INT PRIMARY KEY AUTO_INCREMENT,
    platform VARCHAR(50),
    url VARCHAR(255)
);