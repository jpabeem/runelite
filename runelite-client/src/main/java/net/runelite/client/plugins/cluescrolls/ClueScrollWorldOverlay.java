/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.cluescrolls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
<<<<<<< HEAD
=======
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import javax.inject.Inject;
import net.runelite.client.plugins.cluescrolls.clues.ClueScroll;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class ClueScrollWorldOverlay extends Overlay
{
	public static final int IMAGE_Z_OFFSET = 30;

<<<<<<< HEAD
=======
	public static final BufferedImage EMOTE_IMAGE;
	public static final BufferedImage CLUE_SCROLL_IMAGE;
	public static final BufferedImage SPADE_IMAGE;

>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	public static final Color CLICKBOX_BORDER_COLOR = Color.ORANGE;
	public static final Color CLICKBOX_HOVER_BORDER_COLOR = CLICKBOX_BORDER_COLOR.darker();
	public static final Color CLICKBOX_FILL_COLOR = new Color(0, 255, 0, 20);

	private final ClueScrollPlugin plugin;

<<<<<<< HEAD
=======
	static
	{
		try
		{
			synchronized (ImageIO.class)
			{
				EMOTE_IMAGE = ImageIO.read(ClueScrollPlugin.class.getResourceAsStream("emote.png"));
				CLUE_SCROLL_IMAGE = ImageIO.read(ClueScrollPlugin.class.getResourceAsStream("clue_scroll.png"));
				SPADE_IMAGE = ImageIO.read(ClueScrollPlugin.class.getResourceAsStream("spade.png"));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}

>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	@Inject
	public ClueScrollWorldOverlay(ClueScrollPlugin plugin)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		ClueScroll clue = plugin.getClue();

		if (clue != null)
		{
			clue.makeWorldOverlayHint(graphics, plugin);
		}

		return null;
	}
}
