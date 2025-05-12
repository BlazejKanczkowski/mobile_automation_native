package org.example.tests;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.pages.DrawingPageBase;
import org.example.pages.ProductListPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DrawingRecognitionTest extends BaseTest implements IAbstractTest {

    @Test
    public void testDrawnSquareIsRecognized() throws IOException {

        ProductListPageBase productPage = loginAsStandardUser(true);
        Assert.assertTrue(productPage.isProductListVisible(), "Product page not loaded.");

        getMenuPage().openDrawingPage();

        DrawingPageBase drawingPage = initPage(getDriver(), DrawingPageBase.class);
        Assert.assertTrue(drawingPage.isCanvasVisible(), "Canvas not visible");

        drawingPage.drawLine();

        Assert.assertTrue(drawingPage.isShapeVisible(), "No shape was found");
    }
}
