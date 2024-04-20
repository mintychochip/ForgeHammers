/*
 *
 *  Copyright (C) 2024 mintychochip
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package mintychochip.forgehammers.listeners;

import java.util.function.Predicate;
import mintychochip.forgehammers.AbstractListener;
import mintychochip.forgehammers.container.ForgeHammers;
import mintychochip.forgehammers.container.HammerLike;
import mintychochip.forgehammers.container.ToolPerks.Perk;
import mintychochip.forgehammers.container.gem.GemContainer;
import mintychochip.forgehammers.container.gem.GemEnum;
import mintychochip.forgehammers.container.gem.GemGrasper;
import mintychochip.forgehammers.events.DropEvent;
import mintychochip.forgehammers.events.PreBlockDropEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.inventory.ItemStack;

public class DropListener extends AbstractListener {

  public DropListener(ForgeHammers instance) {
    super(instance);
  }

  @EventHandler
  private void onDropItemEvent(final DropEvent event) {
    Location dropLocation = event.getDropLocation();
    event.getDrops().forEach(drop -> dropLocation.getWorld().dropItemNaturally(dropLocation, drop));
  }

  @EventHandler(priority = EventPriority.MONITOR)
  private void initializeBlockDropEvent(final PreBlockDropEvent event) {
    if (event.isCancelled()) {
      return;
    }
    Bukkit.getPluginManager().callEvent(new DropEvent(event.getBlockLocation(), event.getDrops()));
  }
}
