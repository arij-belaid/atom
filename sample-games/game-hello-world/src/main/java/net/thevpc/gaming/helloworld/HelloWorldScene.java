package net.thevpc.gaming.helloworld;

import net.thevpc.gaming.atom.annotations.AtomScene;
import net.thevpc.gaming.atom.annotations.AtomSceneEngine;
import net.thevpc.gaming.atom.annotations.Inject;
import net.thevpc.gaming.atom.annotations.OnSceneStarted;
import net.thevpc.gaming.atom.debug.AdjustViewController;
import net.thevpc.gaming.atom.engine.DefaultSceneEngine;
import net.thevpc.gaming.atom.engine.SceneEngine;
import net.thevpc.gaming.atom.engine.SpriteFilter;
import net.thevpc.gaming.atom.model.Orientation;
import net.thevpc.gaming.atom.model.Point;
import net.thevpc.gaming.atom.model.Sprite;
import net.thevpc.gaming.atom.presentation.*;
import net.thevpc.gaming.atom.presentation.components.SLabel;
import net.thevpc.gaming.atom.presentation.layers.*;

import java.awt.*;

import net.thevpc.gaming.atom.presentation.Scene;



@AtomScene(
        id = "hello",
        title = "Hello World",
        tileWidth = 80,
        tileHeight = 80

)
@AtomSceneEngine(
        id="hello",
        columns = 10,
        rows = 10,
        fps = 25
)
// Together, these snippets create a 10x10 grid of tiles,
// each with a size of 80x80 pixels, in a scene titled "Hello World


public class HelloWorldScene {


    @Inject
    private Scene scene;
    @Inject
    private SceneEngine sceneEngine;
    // Reference to the label displaying lives
    private Label lifeLabel;
    private DefaultSceneEngine SpriteModel;

    // Reference to the ball sprite
    //private Sprite ball;

    @OnSceneStarted

    private void init() {

//3.1.2:

        scene.addLayer(Layers.fillBoardGradient(Color.GREEN,Color.BLUE, Orientation.NORTH));// Board: BLUE dégradé vers green
        scene.addLayer(Layers.fillBoardImage("/welcome.jpg"));
        scene.addLayer(Layers.debug());

//3.1.3:

        //  scene.addLayer(Layers.fillScreen(Color.RED));// screen: red;
//3.1.5
//BOARD
//         String image1Path = "/eniso.jpeg"; // Adjust the path if needed

        //         ImageBoardLayer BoardLayer = new ImageBoardLayer(image1Path);
        //  scene.addLayer(BoardLayer);
// SCREEN

        String imagePath = "/welcome.jpg";
        ImageScreenLayer ScreenLayer = new ImageScreenLayer(imagePath);
        scene.addLayer(ScreenLayer);

//3.2.1
        Label:
        scene.addComponent(
                new SLabel(" Vies: 3")
                        .setLocation(Point.ratio(0.5f,0.4f))
        );
//3.2.2:


//4.1.

        scene.addController(new SpriteController2(SpriteFilter.byName("Ball1")));
        scene.addController(new SpriteController2(SpriteFilter.byName("Ball2")));

        scene.addController(new AdjustViewController());
        scene.addComponent(
                new SLabel("Click CTRL-D to switch debug mode, use Arrows to move the ball")
                        .setLocation(Point.ratio(0.5f,0.5f)));

//3.2.
// Définir l'apparence de la première balle (Ball1)
        scene.setSpriteView(SpriteFilter.byKind("Ball"), new ImageSpriteView("/ball.png", 8, 4));
        scene.setSpriteView(SpriteFilter.byKind("Ball2"), new ImageSpriteView("/ball2.jpeg", 7, 4));

// Changer l'affichage de la deuxième balle (Ball2) pour une forme carrée de couleur magenta
        scene.setSpriteView(SpriteFilter.byName("Ball2"), new DefaultSpriteView() {
            @Override
            public void draw(SpriteDrawingContext context) {
                // Récupérer le sprite
                Sprite sprite = context.getSprite();

                // Obtenir Graphics2D depuis le contexte
                Graphics2D g = context.getGraphics();

                // Définir la couleur Magenta
                g.setColor(Color.MAGENTA);

// Récupérer la forme du sprite (par défaut, cela pourrait être un rectangle)
                Shape spriteShape = context.getSpriteShape();

                // Dessiner la forme en utilisant Graphics2D
                g.fill(spriteShape);

            }
        });
    }
    public void aChaqueTic() {
        // Récupération du Sprite de la balle via son nom
        Sprite ball = SpriteModel.findSpriteByName("ball");
        if (ball != null) {
            // Mise à jour du texte du label avec les vies restantes
            int remainingLives = ball.getLife();
            lifeLabel.setText("Vies restantes : " + remainingLives);
        }
    }


}