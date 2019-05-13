<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>


    <xsl:template match="/customers">
        <body>
            <table border="1">
                <tr>
                    <td>Address</td>
                    <td>City</td>
                    <td>Region</td>
                    <td>PostalCode</td>
                    <td>Country</td>
                    <td>Price</td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </body>
    </xsl:template>

    <xsl:template match="/customers/customer">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/customers/customer/orders">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/customers/customer/orders/order">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/customers/customer/orders/order/address">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/customers/customer/orders/order/city">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/customers/customer/orders/order/region">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/customers/customer/orders/order/postalCode">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/customers/customer/orders/order/country">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/customers/customer/orders/order/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>


</xsl:stylesheet>