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

package mintychochip.forgehammers.events;

import java.util.Collection;
import mintychochip.genesis.events.AbstractEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FakeBlockDropItemEvent extends AbstractEvent {
  private final Player player;
  private final Location location;
  private final ItemStack item;
  private Collection<ItemStack> drops;
  public FakeBlockDropItemEvent(Player player, Location location, Collection<ItemStack> drops, ItemStack item) {
    this.player = player;
    this.location = location;
    this.drops = drops;
    this.item = item;
  }
  public ItemStack getItem() {
    return item;
  }
  public void setDrops(Collection<ItemStack> drops) {
    this.drops = drops;
  }
  public Player getPlayer() {
    return player;
  }

  public Location getLocation() {
    return location;
  }

  public Collection<ItemStack> getDrops() {
    return drops;
  }
}