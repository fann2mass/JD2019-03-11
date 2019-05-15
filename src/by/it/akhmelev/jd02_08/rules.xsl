<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html"/>

  <xsl:template match="/users">
    <body>
      <table border="1">
        <tr>
          <td>Address</td>
          <td>Description</td>
          <td>Floor</td>
          <td>Floors</td>
          <td>Rooms</td>
          <td>Price</td>
        </tr>
        <xsl:apply-templates/>
      </table>
    </body>
  </xsl:template>

  <xsl:template match="/users/user">
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="/users/user/ads">
    <xsl:apply-templates/>
  </xsl:template>

  <xsl:template match="/users/user/ads/ad">
    <tr><xsl:apply-templates/></tr>
  </xsl:template>

  <xsl:template match="/users/user/ads/ad/address">
    <td><xsl:apply-templates/></td>
  </xsl:template>

  <xsl:template match="/users/user/ads/ad/description">
    <td><xsl:apply-templates/></td>
  </xsl:template>

  <xsl:template match="/users/user/ads/ad/floor">
    <td><xsl:apply-templates/></td>
  </xsl:template>

  <xsl:template match="/users/user/ads/ad/floors">
    <td><xsl:apply-templates/></td>
  </xsl:template>

  <xsl:template match="/users/user/ads/ad/rooms">
    <td><xsl:apply-templates/></td>
  </xsl:template>

  <xsl:template match="/users/user/ads/ad/price">
    <td><xsl:apply-templates/></td>
  </xsl:template>


</xsl:stylesheet>