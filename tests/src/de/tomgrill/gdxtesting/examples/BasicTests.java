//  Taken from https://github.com/TomGrill/gdx-testing

package de.tomgrill.gdxtesting.examples;

import com.badlogic.gdx.Gdx;
import com.unciv.UncivGame;
import com.unciv.models.ruleset.Ruleset;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.tomgrill.gdxtesting.GdxTestRunner;

import static org.junit.Assert.assertTrue;

// DO NOT attempt to Kotlinize until you're sure that running gradle tests:test actually checks stuff!

@RunWith(GdxTestRunner.class)
public class BasicTests {

	@Test
	public void gamePngExists() {
		assertTrue("This test will only pass when the game.png exists",
				Gdx.files.local("game.png").exists());
	}

	@Test
	public void loadRuleset() {
		assertTrue("This test will only pass when the jsons can be loaded",
				new Ruleset(true).getBuildings().size() > 0);
	}

	@Test
	public void gameIsNotRunWithDebugModes() {
		assertTrue("This test will only pass if the game is not run with debug modes",
				!new UncivGame("").getSuperchargedForDebug()
						&& !new UncivGame("").getViewEntireMapForDebug());
	}


//	@Test
//	public void setMapEditorScreen() {
//		new UncivGame("").create(); // sets the current
//		UncivGame.Current.setScreen(new MapEditorScreen(UncivGame.Current.getGameInfo().getTileMap()));
//		assertTrue("This test will only pass when we can open the map editor screen",
//				GameBasics.INSTANCE.getBuildings().size() > 0);
//	}

}