# Software Quality Engineering - System Testing
This is a repository for the system-testing assignment of the Software Quality Engineering course at the [Ben-Gurion University](https://in.bgu.ac.il/), Israel.

## Assignment Description
In this assignment, we tested an open-source software called [PrestaShop](https://localhost:8080).

PrestaShop is an open-source e-commerce platform that allows businesses to create and manage online stores efficiently. It offers a customizable and user-friendly interface, supporting various payment methods, shipping options, and integrations to enhance online selling.

## Installation
PrestaShop Installation & Testing Setup
Installation
Download PrestaShop from prestashop.com.
Set Up Server (Apache/Nginx, PHP 7.1+, MySQL 5.6+).
Extract Files to your server (local or web).
Create Database via phpMyAdmin.
Run Installer at http://localhost/prestashop and follow the steps.
Testing Setup
Enable Debug Mode: Edit config/defines.inc.php → _PS_MODE_DEV_ = true;
Install Selenium:
sh
Copy
Edit
npm install -g selenium-webdriver
Download ChromeDriver (match Chrome version).
Create Test Data in the admin panel.
Run Tests using Selenium, PHPUnit, or Behat.

## What we tested
We tested the eCommerce workflow module in PrestaShop, focusing on both user purchase flow and admin stock management. The module ensures a seamless experience for customers and administrators.

User Stories & Expected Outcomes
User Purchase Flow
User story: A customer navigates to a product page and adds an item to the cart.

Preconditions: A customer is logged in.
Expected outcome: The product is added to the cart.
User story: A customer proceeds to checkout and completes the payment.

Preconditions: The cart contains at least one item.
Expected outcome: The order is confirmed, and payment is processed.
User story: A customer session starts and ends after order completion.

Preconditions: A registered customer is using the site.
Expected outcome: The session is properly maintained and closed after purchase.
Admin Stock Management Flow
User story: An admin logs in and updates the maximum quantity for a product.

Preconditions: An admin is logged in.
Expected outcome: The product stock is successfully updated.
User story: An admin modifies stock after a customer completes a purchase.

Preconditions: A successful payment has been made.
Expected outcome: The stock is updated based on the latest purchase.
These test scenarios ensure that the customer shopping experience and admin stock management work correctly within PrestaShop

## How we tested
We used two different testing methods:
1. [Cucumber](https://cucumber.io/), a behavior-driven testing framework.
2. [Provengo](https://provengo.tech/), a story-based testing framework.

Each of the testing methods is elaborated in its own directory. 

## Results
Update all README.md files (except for d-e, see Section 1). Specifically, replace all $$*TODO*…$$ according to the instructions inside the $$.

