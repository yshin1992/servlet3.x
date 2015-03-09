<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.awt.image.*,javax.imageio.*,java.io.*,java.awt.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Response实例</title>
</head>
<body>
	<%
		//创建BufferedImage
		BufferedImage img = new BufferedImage( 340, 160, BufferedImage.TYPE_INT_RGB );
		//以Image对象获取Graphics对象
		Graphics g = img.getGraphics();
		//使用Graphics画图，所画的图像将会出现在image中
		g.fillRect( 0, 0, 400, 400 );
		//设置颜色:红
		g.setColor( new Color( 255, 0, 0 ) );
		//画出一段弧
		g.fillArc( 20, 20, 100, 100, 30, 120 );//填充覆盖指定矩形的圆弧或椭圆弧fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)
		//设置颜色：绿
		g.setColor( new Color( 0, 255, 0 ) );
		g.fillArc( 20, 20, 100, 100, 150, 120 );

		g.setColor( new Color( 0, 0, 255 ) );
		g.fillArc( 20, 20, 100, 100, 270, 120 );

		g.setColor( new Color( 0, 0, 0 ) );
		g.setFont( new Font( "Arial Black", Font.PLAIN, 16 ) );

		g.drawString( "red:climb", 200, 60 );
		g.drawString( "green:swim", 200, 100 );
		g.drawString( "blue:jump", 200, 140 );
		g.dispose();
		//将图像输出到页面的响应
		ImageIO.write( img, "jpg", response.getOutputStream() );
		out.clear();
		out = pageContext.pushBody();
	%>
</body>
</html>