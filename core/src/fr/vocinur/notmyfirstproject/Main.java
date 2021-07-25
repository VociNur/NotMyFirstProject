package fr.vocinur.notmyfirstproject;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import fr.vocinur.notmyfirstproject.network.Request;
import fr.vocinur.notmyfirstproject.threading.MyFirstThread;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	private boolean fullScreenMode = false;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		System.out.println("Vibrate! ");

		


		Music music = Gdx.audio.newMusic(Gdx.files.getFileHandle("K C'EST UNE CONSTANTE PTN !!! .mp3", Files.FileType.Internal));
		music.setVolume(0.1f);
		music.play();

		new Request();
		new MyFirstThread();
	}

	@Override
	public void render () {
		if (Gdx.input.isTouched()) {
			System.out.println("Input occurred at x=" + Gdx.input.getX() + ", y=" + Gdx.input.getY());

			if(Gdx.input.getX() < 10 && Gdx.input.getY() < 10){

				if(this.fullScreenMode){
					Gdx.graphics.setWindowedMode(500, 500);
					fullScreenMode = false;
				}else{

					Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
					fullScreenMode = true;
				}

			}
		}

		if (Gdx.input.isKeyPressed(Input.Keys.P)){
			long javaHeap = Gdx.app.getJavaHeap();
			long nativeHeap = Gdx.app.getNativeHeap();
			Gdx.app.log("heap", javaHeap + "/" + nativeHeap);
		}
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.end();

	}

	@Override
	public void pause(){
	}
	@Override
	public void dispose () {
		batch.dispose();
	}
}
