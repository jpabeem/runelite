/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package net.runelite.client.plugins.cerberus;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ImageComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
=======
import net.runelite.api.NPC;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.ImagePanelComponent;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

@Slf4j
@Singleton
public class CerberusOverlay extends Overlay
{
	private final CerberusPlugin plugin;
	private final SkillIconManager iconManager;
<<<<<<< HEAD
	private final PanelComponent panelComponent = new PanelComponent();
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

	@Inject
	CerberusOverlay(final CerberusPlugin plugin, final SkillIconManager iconManager)
	{
		this.plugin = plugin;
		this.iconManager = iconManager;
		setPosition(OverlayPosition.BOTTOM_RIGHT);
<<<<<<< HEAD
		panelComponent.setOrientation(PanelComponent.Orientation.HORIZONTAL);
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getGhosts().isEmpty())
		{
			return null;
		}

<<<<<<< HEAD
		panelComponent.getChildren().clear();

		// Ghosts are already sorted
		plugin.getGhosts().stream()
			// Iterate only through the correct amount of ghosts
			.limit(CerberusGhost.values().length)
			.forEach(npc -> CerberusGhost
				.fromNPC(npc)
				.ifPresent(ghost -> panelComponent
					.getChildren()
					.add(new ImageComponent(iconManager.getSkillImage(ghost.getType())))));


		return panelComponent.render(graphics);
=======
		final ImagePanelComponent imagePanelComponent = new ImagePanelComponent();
		imagePanelComponent.setTitle("Ghost order");

		for (final NPC npc : plugin.getGhosts())
		{
			CerberusGhost.fromNPC(npc).ifPresent(ghost -> imagePanelComponent
				.getImages().add(iconManager.getSkillImage(ghost.getType())));
		}

		return imagePanelComponent.render(graphics);
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	}
}
