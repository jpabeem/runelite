/*
 * Copyright (c) 2018, Lars <lars.oernlo@gmail.com>
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
package net.runelite.client.plugins.motherlode;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
<<<<<<< HEAD
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
=======
import net.runelite.client.ui.overlay.components.PanelComponent;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

public class MotherlodeGemOverlay extends Overlay
{
	private final MotherlodePlugin plugin;
	private final MotherlodeConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MotherlodeGemOverlay(MotherlodePlugin plugin, MotherlodeConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		MotherlodeSession session = plugin.getSession();

		if (session.getLastGemFound() == null || !plugin.isInMlm() || !config.showGemsFound())
		{
			return null;
		}

		Duration statTimeout = Duration.ofMinutes(config.statTimeout());
		Duration sinceCut = Duration.between(session.getLastGemFound(), Instant.now());

		if (sinceCut.compareTo(statTimeout) >= 0)
		{
			return null;
		}

		int diamondsFound = session.getDiamondsFound();
		int rubiesFound = session.getRubiesFound();
		int emeraldsFound = session.getEmeraldsFound();
		int sapphiresFound = session.getSapphiresFound();

<<<<<<< HEAD
		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(TitleComponent.builder().text("Gems found").build());

		if (diamondsFound > 0)
		{
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Diamonds:")
				.right(Integer.toString(diamondsFound))
				.build());
=======
		panelComponent.getLines().clear();

		panelComponent.setTitle("Gems found");

		if (diamondsFound > 0)
		{
			panelComponent.getLines().add(new PanelComponent.Line(
					"Diamonds:",
					Integer.toString(diamondsFound)
			));
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}

		if (rubiesFound > 0)
		{
<<<<<<< HEAD
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Rubies:")
				.right(Integer.toString(rubiesFound))
				.build());
=======
			panelComponent.getLines().add(new PanelComponent.Line(
					"Rubies:",
					Integer.toString(rubiesFound)
			));
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}

		if (emeraldsFound > 0)
		{
<<<<<<< HEAD
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Emeralds:")
				.right(Integer.toString(emeraldsFound))
				.build());
=======
			panelComponent.getLines().add(new PanelComponent.Line(
					"Emeralds:",
					Integer.toString(emeraldsFound)
			));
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		}

		if (sapphiresFound > 0)
		{
<<<<<<< HEAD
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Sapphires:")
				.right(Integer.toString(sapphiresFound))
				.build());
		}

=======
			panelComponent.getLines().add(new PanelComponent.Line(
					"Sapphires:",
					Integer.toString(sapphiresFound)
			));
		}
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		return panelComponent.render(graphics);
	}
}
