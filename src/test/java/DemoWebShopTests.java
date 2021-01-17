import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoWebShopTests {

    @Test
    @DisplayName("Successful added to wish list")
    void successfulAddToWishlistTest() {
        String cookie = "Nop.customer=dd3f4449-d9e1-4858-a312-8b1dd13980ed; ARRAffinity=7f10010dd6b12d83d6aefe199065b2e8fe0d0850a7df2983b482815225e42439; __utmc=78382081; __utmz=78382081.1610868256.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ym_uid=1610869915918550451; _ym_d=1610869915; _ym_isad=2; fid=cab6d552-e670-4d98-84a5-e8a3dd5c34f5; nop.CompareProducts=CompareProductIds=13; __gads=ID=829ab986a720af35:T=1610869948:S=ALNI_MbcorrorMNZ8zPxbRncyqZM9UrAAA; _ga=GA1.2.1251574826.1610868256; _gid=GA1.2.2142568900.1610869949; __RequestVerificationToken=WD9SYHc42lcIvQieESHLIQNhQVxcD1_G3zTzZ1VwMLM7AGG3PCxiE9y_V4GzhNxY00GRywJDrTkttJuE_mTL6xzeCw0YbZuS_DDjvSJ4z6M1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2&RecentlyViewedProductIds=21&RecentlyViewedProductIds=13; __utma=78382081.1251574826.1610868256.1610876286.1610880928.4; __utmt=1; __atuvc=10%7C3; __atuvs=6004179fc87a4126003; __utmb=78382081.4.10.1610880928";
        String body = "giftcard_2.RecipientName=qwe&giftcard_2.RecipientEmail=qwe%40we.ru&giftcard_2.SenderName=faswqe&giftcard_2.SenderEmail=sada%40saa.ru&giftcard_2.Message=qwe&addtocart_2.EnteredQuantity=1";

        given()
                .body(body)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookie)
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/2/2")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Added to wish list with assert")
    void addToWishListWithSimpleAssertTest() {
        String cookie = "Nop.customer=dd3f4449-d9e1-4858-a312-8b1dd13980ed; ARRAffinity=7f10010dd6b12d83d6aefe199065b2e8fe0d0850a7df2983b482815225e42439; __utmc=78382081; __utmz=78382081.1610868256.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ym_uid=1610869915918550451; _ym_d=1610869915; _ym_isad=2; fid=cab6d552-e670-4d98-84a5-e8a3dd5c34f5; nop.CompareProducts=CompareProductIds=13; __gads=ID=829ab986a720af35:T=1610869948:S=ALNI_MbcorrorMNZ8zPxbRncyqZM9UrAAA; _ga=GA1.2.1251574826.1610868256; _gid=GA1.2.2142568900.1610869949; __RequestVerificationToken=WD9SYHc42lcIvQieESHLIQNhQVxcD1_G3zTzZ1VwMLM7AGG3PCxiE9y_V4GzhNxY00GRywJDrTkttJuE_mTL6xzeCw0YbZuS_DDjvSJ4z6M1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2&RecentlyViewedProductIds=21&RecentlyViewedProductIds=13; __utma=78382081.1251574826.1610868256.1610876286.1610880928.4; __utmt=1; __atuvc=10%7C3; __atuvs=6004179fc87a4126003; __utmb=78382081.4.10.1610880928";
        String body = "giftcard_2.RecipientName=qwe&giftcard_2.RecipientEmail=qwe%40we.ru&giftcard_2.SenderName=faswqe&giftcard_2.SenderEmail=sada%40saa.ru&giftcard_2.Message=qwe&addtocart_2.EnteredQuantity=1";

       Response response = given()
                .body(body)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookie)
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/2/2")
                .then()
                .statusCode(200)
               .extract().response();

       assertTrue(response.asString().contains("The product has been added to your"));
        }

    @Test
    @DisplayName("Added to wish list with body assert")
    void addedToWishListWithBodyAssertTest() {
        String cookie = "Nop.customer=dd3f4449-d9e1-4858-a312-8b1dd13980ed; ARRAffinity=7f10010dd6b12d83d6aefe199065b2e8fe0d0850a7df2983b482815225e42439; __utmc=78382081; __utmz=78382081.1610868256.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ym_uid=1610869915918550451; _ym_d=1610869915; _ym_isad=2; fid=cab6d552-e670-4d98-84a5-e8a3dd5c34f5; nop.CompareProducts=CompareProductIds=13; __gads=ID=829ab986a720af35:T=1610869948:S=ALNI_MbcorrorMNZ8zPxbRncyqZM9UrAAA; _ga=GA1.2.1251574826.1610868256; _gid=GA1.2.2142568900.1610869949; __RequestVerificationToken=WD9SYHc42lcIvQieESHLIQNhQVxcD1_G3zTzZ1VwMLM7AGG3PCxiE9y_V4GzhNxY00GRywJDrTkttJuE_mTL6xzeCw0YbZuS_DDjvSJ4z6M1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2&RecentlyViewedProductIds=21&RecentlyViewedProductIds=13; __utma=78382081.1251574826.1610868256.1610876286.1610880928.4; __utmt=1; __atuvc=10%7C3; __atuvs=6004179fc87a4126003; __utmb=78382081.4.10.1610880928";
        String body = "giftcard_2.RecipientName=qwe&giftcard_2.RecipientEmail=qwe%40we.ru&giftcard_2.SenderName=faswqe&giftcard_2.SenderEmail=sada%40saa.ru&giftcard_2.Message=qwe&addtocart_2.EnteredQuantity=1";

         given()
                .body(body)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookie)
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/2/2")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/wishlist\">wishlist</a>"));
    }

    @Test
    @DisplayName("Added to wish list with model")
    void addedToWishListWithModel() {
        String cookie = "Nop.customer=dd3f4449-d9e1-4858-a312-8b1dd13980ed; ARRAffinity=7f10010dd6b12d83d6aefe199065b2e8fe0d0850a7df2983b482815225e42439; __utmc=78382081; __utmz=78382081.1610868256.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ym_uid=1610869915918550451; _ym_d=1610869915; _ym_isad=2; fid=cab6d552-e670-4d98-84a5-e8a3dd5c34f5; nop.CompareProducts=CompareProductIds=13; __gads=ID=829ab986a720af35:T=1610869948:S=ALNI_MbcorrorMNZ8zPxbRncyqZM9UrAAA; _ga=GA1.2.1251574826.1610868256; _gid=GA1.2.2142568900.1610869949; __RequestVerificationToken=WD9SYHc42lcIvQieESHLIQNhQVxcD1_G3zTzZ1VwMLM7AGG3PCxiE9y_V4GzhNxY00GRywJDrTkttJuE_mTL6xzeCw0YbZuS_DDjvSJ4z6M1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2&RecentlyViewedProductIds=21&RecentlyViewedProductIds=13; __utma=78382081.1251574826.1610868256.1610876286.1610880928.4; __utmt=1; __atuvc=10%7C3; __atuvs=6004179fc87a4126003; __utmb=78382081.4.10.1610880928";
        String body = "giftcard_2.RecipientName=qwe&giftcard_2.RecipientEmail=qwe%40we.ru&giftcard_2.SenderName=faswqe&giftcard_2.SenderEmail=sada%40saa.ru&giftcard_2.Message=qwe&addtocart_2.EnteredQuantity=1";

        WishListResponse response = given()
                .body(body)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie(cookie)
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/2/2")
                .then()
                .statusCode(200)
                .extract().as(WishListResponse.class);
    }
}
