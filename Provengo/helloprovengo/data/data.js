/*
 * Constants and test data for PrestaShop tests
 */

const ADMIN_URL = 'http://localhost:8080/admina';

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