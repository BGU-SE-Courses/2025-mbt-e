/*
 *  This is a good place to put common test data, project-wide constants, etc.
 */

const URL = 'http://localhost:8080';
const ADMIN_URL = 'http://localhost:8080/admina';

const xpaths = {
  productPage: {
    product: "//picture[1]/img[1]", // Click on the first product
    addToCartButton: "//div[1]/div[2]/button[1]", // Add to cart button
    addQuantityButton: "//span[3]/button[1]/i[1]", // Adjust quantity (matches same button)
  },
  cart: {
    proceedToCheckoutButton: "//div[2]/div[1]/div[1]/a[1]", // Proceed to checkout button
    proceedToCheckoutButton2: "//div[2]/div[1]/div[2]/div[1]/a[1]", // Proceed to checkout button 2
  },
  checkout: {
    mrs: "//*[@id='field-id_gender-1']", // Mrs. radio button
    firstName: "//*[@id='field-firstname']", // First name input field
    lastName: "//*[@id='field-lastname']", // Last name input field
    email: "//div[4]/div[1]/input[1]", // Email input field
    //email: "//*[@id='field-email']", // Email input field
    agreeBox: "//div[8]/div[1]/span[1]/label[1]/input[1]", // Agree to terms checkbox
    dataPrivacyBox: "//div[10]/div[1]/span[1]/label[1]/input[1]", // Agree to data privacy checkbox
    continueButton: "//div[1]/form[1]/footer[1]/button[1]", // Continue button
    address: "//*[@id='field-address1']", // Address input field
    city: "//*[@id='field-city']", // City input field
    postcode: "//*[@id='field-postcode']",
    countryDropdown: "//*[@id='field-id_country']",
    continueButton1: "//*[contains(@name, \"confirm-addresses\")]",
    confirmOrderButton: "//*[contains(@name, \"confirmDeliveryOption\")]", // Confirm order button
  },
  payment: {
    paymentMethod: "//*[@id='payment-option-3']", // Payment method
    paymentConfirmation: "//li[1]/div[1]/span[1]/input[1]", // Payment confirmation checkbox
    orderConfirmation: "//*[@id='payment-confirmation']/div[1]/button[1]" // Order confirmation button
  },
  orderConfirmation: {
    confirmationMessage: "//div[1]/h3[1]/i[1]", // Confirmation message
    emailMessage: "//p[contains(text(), 'An email has been sent')]", // Email message confirmation
  },
};

const testUser = {
  firstName: "John",
  lastName: "Doe",
  email: "johndoe@example.com",
  address: "123 Test Street",
  city: "Testville",
};

const expectedTexts = {
  confirmationMessage: "Your order is confirmed",
  emailMessage: "An email has been sent to the",
};

const xpaths_ADMIN = {
    Admin_loginForm: {
      email: "//*[@id='email']",
      password: "//*[@id='passwd']",
      submitButton: "//div[3]/button[1]",
      dashboard: "/html/body/div[1]/div/div[1]/div/div/h1"
    },
    catalog: {
      catalogMenu: "//*[@id='subtab-AdminCatalog']",
      productsMenu: "//*[@id='subtab-AdminProducts']",
      firstProductEdit: "//tr[1]/td[9]/a[1]",
      productEditLabel: "//div[2]/div[1]/div[1]/div[1]/label[1]"
    },
    stock: {
      currentQuantity: "//div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]",
      deltaQuantity: "//*[@id='product_stock_quantities_delta_quantity_delta']",
      saveButton: "//*[@id='product_footer_save']",
      successMessage: "//form[1]/div[3]"
    }
};
const Admin_email = "demo@prestashop.com";
const Admin_password = "prestashop_demo";
const Quantity_To_Delete = "-299"
const targetQuantity = 1;

