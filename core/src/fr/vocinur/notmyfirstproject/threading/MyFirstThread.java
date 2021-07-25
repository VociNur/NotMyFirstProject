package fr.vocinur.notmyfirstproject.threading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import javax.xml.transform.Result;

public class MyFirstThread {
//    Je sais pas si ça marche :/

    public MyFirstThread() {
        final Array<Result> results = new Array<Result>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // do something important here, asynchronously to the rendering thread

                System.out.println("1");
                final Result result = createResult();
                // post a Runnable to the rendering thread that processes the result

                System.out.println("3");
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        // process the result, e.g. add it to an Array<Result> field of the ApplicationListener.

                        System.out.println("4");
                        results.add(result);

                        System.out.println("5");

                    }
                });
            }
            private Result createResult() {
                System.out.println("3");
                return null;
            }

        }).start();
    }
}
