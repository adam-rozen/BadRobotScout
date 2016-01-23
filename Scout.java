package com.dchs.scout;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Scout extends ApplicationAdapter {
	
	SpriteBatch batch, batch2, batch3; 
	SpriteBatch batch4, batch5;
	public static Texture img = null;
	Texture circ = null;
	SimplerTouch x;
	public static BitmapFont font;
	public static TextButton line, freeform;
	public static boolean bool = false;
	
	@Override
	public void create () 
	{
		batch = new SpriteBatch();
		batch2 = new SpriteBatch();
		batch3 = new SpriteBatch();
		batch4 = new SpriteBatch();
		batch5 = new SpriteBatch();
		img = new Texture("../core/src/com/dchs/scout/Background.jpg");
		circ = new Texture("../core/src/com/dchs/scout/rsz_11untitled.png");
		font = new BitmapFont();		
		SimplerTouch simplerTouch = new SimplerTouch();
		
		Gdx.input.setInputProcessor(simplerTouch);
		
	}

	
	ShapeRenderer shape;
	public static ShapeRenderer shape2;
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(img, img.getWidth(), 0);
		CharSequence str = "Lines";
		font.draw(batch, str, img.getWidth()*2 + 10, img.getHeight()-600);
		str = "Squares";
		font.draw(batch, str, img.getWidth()*2 + 45, img.getHeight()-670);
		batch.end();
		
		batch2.begin();
		batch2.setColor(Color.BLUE);
		batch2.draw(circ, img.getWidth()*2 + 10, img.getHeight()-180,60,60);
		batch2.end();
		
		batch3.begin();
		batch3.setColor(Color.RED);
		batch3.draw(circ, img.getWidth()*2 + 45, img.getHeight()-250,60,60);
		batch3.end();
		
		batch4.begin();
		batch4.setColor(Color.GREEN);
		batch4.draw(circ, img.getWidth()*2 + 10, img.getHeight()-320,60,60);
		batch4.end();
		
		batch5.begin();
		batch5.setColor(Color.YELLOW);
		batch5.draw(circ, img.getWidth()*2 + 45, img.getHeight()-390,60,60);
		batch5.end();
		
		/*shape = new ShapeRenderer();
		shape.begin(ShapeType.Filled);
		shape.setColor(com.badlogic.gdx.graphics.Color.BLUE);
		shape.circle(img.getWidth()*2+40, img.getHeight()-150, 30);
		shape.setColor(com.badlogic.gdx.graphics.Color.RED);
		shape.circle(img.getWidth()*2+75, img.getHeight()-220, 30);
		shape.setColor(com.badlogic.gdx.graphics.Color.GREEN);
		shape.circle(img.getWidth()*2+40, img.getHeight()-290, 30);
		shape.setColor(com.badlogic.gdx.graphics.Color.YELLOW);
		shape.circle(img.getWidth()*2+75, img.getHeight()-360, 30);
		shape.setColor(com.badlogic.gdx.graphics.Color.BROWN);
		shape.circle(img.getWidth()*2+40, img.getHeight()-430, 30);
		shape.setColor(com.badlogic.gdx.graphics.Color.VIOLET);
		shape.circle(img.getWidth()*2+75, img.getHeight()-500, 30);
		shape.end();*/

		
		
		shape2 = new ShapeRenderer();
		shape2.begin(ShapeType.Filled);
		
//		for(int i = 0; i < SimplerTouch.touchPosDown.size() && i < SimplerTouch.touchPosUp.size(); i++)
	//		shape.line(SimplerTouch.touchPosDown.get(i).x, Gdx.graphics.getHeight()-SimplerTouch.touchPosDown.get(i).y, SimplerTouch.touchPosUp.get(i).x, Gdx.graphics.getHeight()-SimplerTouch.touchPosUp.get(i).y);
		
		if(bool)
			for(int i = 0; i < SimplerTouch.touchPosXY.size(); i++)
				for(int k = 0; k < SimplerTouch.touchPosXY.get(i).size(); k++)
					if (k!=0)
						shape.line(SimplerTouch.touchPosDown.get(k), SimplerTouch.touchPosXY.get(i).get(k));
					else
						shape.line(SimplerTouch.touchPosXY.get(i).get(k-1), SimplerTouch.touchPosXY.get(i).get(k));
					
		else
			for(int i = 0; i < SimplerTouch.touchPosXY.size(); i++)
				for(int k = 0; k < SimplerTouch.touchPosXY.get(i).size(); k++)
				{
					ShapeRenderer tes2 = tes.get(i);
					tes2.begin(ShapeType.Filled);
					tes2.setColor(col.get(i));
					//System.out.println(i);
					//	System.out.println(k);
					//System.out.println(col.get(i));
					
					tes2.rect(SimplerTouch.touchPosXY.get(i).get(k).x, SimplerTouch.touchPosXY.get(i).get(k).y,5,5,col.get(i),col.get(i),col.get(i),col.get(i));
					tes2.end();
				}
		
		shape2.end();
//		System.out.println(SimplerTouch.touchPosXY.size());
		
		
		
	}

	public static ArrayList<Color> col = new ArrayList<Color>();
	public static ArrayList<ShapeRenderer> tes = new ArrayList<ShapeRenderer>();
	
	@Override
	public void dispose(){
		batch.dispose();
		img.dispose();
		//shape.dispose();
	}
}