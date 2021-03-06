/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package net.runelite.client.ui;

<<<<<<< HEAD
import java.awt.Image;
=======
import java.awt.image.BufferedImage;
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class DrawManager
{
<<<<<<< HEAD
	private final List<Consumer<Image>> everyFrame = new CopyOnWriteArrayList<>();
	private final Queue<Consumer<Image>> nextFrame = new ConcurrentLinkedQueue<>();

	public void registerEveryFrameListener(Consumer<Image> everyFrameListener)
=======
	private final List<Consumer<BufferedImage>> everyFrame = new CopyOnWriteArrayList<>();
	private final Queue<Consumer<BufferedImage>> nextFrame = new ConcurrentLinkedQueue<>();

	public void registerEveryFrameListener(Consumer<BufferedImage> everyFrameListener)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		if (!everyFrame.contains(everyFrameListener))
		{
			everyFrame.add(everyFrameListener);
		}
	}

<<<<<<< HEAD
	public void unregisterEveryFrameListener(Consumer<Image> everyFrameListener)
=======
	public void unregisterEveryFrameListener(Consumer<BufferedImage> everyFrameListener)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		everyFrame.remove(everyFrameListener);
	}

<<<<<<< HEAD
	public void requestNextFrameListener(Consumer<Image> nextFrameListener)
=======
	public void requestNextFrameListener(Consumer<BufferedImage> nextFrameListener)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
	{
		nextFrame.add(nextFrameListener);
	}

<<<<<<< HEAD
	public void processDrawComplete(Image image)
	{
		for (Consumer<Image> everyFrameListener : everyFrame)
=======
	public void processDrawComplete(BufferedImage image)
	{
		for (Consumer<BufferedImage> everyFrameListener : everyFrame)
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		{
			try
			{
				everyFrameListener.accept(image);
			}
			catch (Exception e)
			{
				log.error("Error in draw consumer", e);
			}
		}

<<<<<<< HEAD
		Consumer<Image> nextFrameListener = nextFrame.poll();
=======
		Consumer<BufferedImage> nextFrameListener = nextFrame.poll();
>>>>>>> c596e7bd5f6fc2aa4f49a75f6e372413b3a3f48b
		while (nextFrameListener != null)
		{
			try
			{
				nextFrameListener.accept(image);
			}
			catch (Exception e)
			{
				log.error("Error in draw consumer", e);
			}
			nextFrameListener = nextFrame.poll();
		}
	}
}
