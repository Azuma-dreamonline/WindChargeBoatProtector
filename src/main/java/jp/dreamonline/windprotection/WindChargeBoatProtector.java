package jp.dreamonline.windprotection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Boat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WindChargeBoatProtector extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // プラグインが有効になった際にイベントリスナーを登録
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getLogger().info("WindChargeBoatProtector is load");
    }

    @Override
    public void onDisable() {
        // プラグインが無効になった際の処理
        Bukkit.getLogger().info("WindChargeBoatProtector is unload");
    }

    @EventHandler
    public void onBoatDamage(VehicleDamageEvent event) {
        if (event.getVehicle() instanceof Boat) {
            if (event.getAttacker() == null) {
              event.setCancelled(true);
            }
        }
    }
}
