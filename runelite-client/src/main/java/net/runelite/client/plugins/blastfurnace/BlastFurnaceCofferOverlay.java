/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.blastfurnace;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.Varbits.BLAST_FURNACE_COFFER;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
<<<<<<< HEAD
import net.runelite.client.ui.overlay.components.LineComponent;
=======
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.util.StackFormatter;

class BlastFurnaceCofferOverlay extends Overlay
{
	private final Client client;
	private final BlastFurnacePlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	BlastFurnaceCofferOverlay(Client client, BlastFurnacePlugin plugin)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (plugin.getConveyorBelt() == null)
		{
			return null;
		}

		Widget sack = client.getWidget(WidgetInfo.BLAST_FURNACE_COFFER);

<<<<<<< HEAD
		panelComponent.getChildren().clear();
=======
		panelComponent.getLines().clear();
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b

		if (sack != null)
		{
			sack.setHidden(true);

<<<<<<< HEAD
			panelComponent.getChildren().add(LineComponent.builder()
				.left("Coffer:")
				.right(StackFormatter.quantityToStackSize(client.getVar(BLAST_FURNACE_COFFER)) + " gp")
				.build());
		}

=======
			panelComponent.getLines().add(new PanelComponent.Line(
				"Coffer:",
				StackFormatter.quantityToStackSize(client.getVar(BLAST_FURNACE_COFFER)) + " gp"
			));
		}
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		return panelComponent.render(graphics);
	}
}