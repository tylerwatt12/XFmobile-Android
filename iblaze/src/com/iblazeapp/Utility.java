package com.iblazeapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;



public class Utility
{
	
	
	
	
	public static String getGameNameFromID(int gameid)
	{
		
		
		String game = null;


		switch (gameid) {
		case 2:
			game = new String("America's Army: Special Forces");
			break;
		case 3:
			game = new String("Unreal Tournament");
			break;
		case 4:
			game = new String("Unreal Tournament 2003");
			break;
		case 5:
			game = new String("Counter-Strike 1.6");
			break;
		case 32:
			game = new String("TeamSpeak");
			break;
		case 33:
			game = new String("Ventrilo");
			break;
		case 34:
			game = new String("Mumble");
			break;
		case 4096:
			game = new String("The Temple of Elemental Evil");
			break;
		case 4097:
			game = new String("Wolfenstein: Enemy Territory");
			break;
		case 4098:
			game = new String("Dark Age of Camelot");
			break;
		case 4099:
			game = new String("Dark Age of Camelot - Shrouded Isles");
			break;
		case 4100:
			game = new String("Dungeon Siege");
			break;
		case 4284:
			game = new String("StarCraft Brood War");
			break;
		case 4101:
			game = new String("StarCraft");
			break;
		case 4285:
			game = new String("Diablo II - Lord of Destruction");
			break;
		case 4102:
			game = new String("Diablo II");
			break;
		case 4103:
			game = new String("XEvil");
			break;
		case 4104:
			game = new String("Meridian 59");
			break;
		case 4105:
			game = new String("Battlefield 1942");
			break;
		case 4106:
			game = new String("Everquest");
			break;
		case 4107:
			game = new String("Halo");
			break;
		case 4108:
			game = new String("Neverwinter Nights");
			break;
		case 4109:
			game = new String("Star Wars Galaxies: An Empire Divided");
			break;
		case 4110:
			game = new String("PlanetSide");
			break;
		case 4111:
			game = new String("Quake III Arena");
			break;
		case 4112:
			game = new String("Warcraft III");
			break;
		case 4113:
			game = new String("Lineage");
			break;
		case 4114:
			game = new String("Medal of Honor Allied Assault");
			break;
		case 4115:
			game = new String("Diablo");
			break;
		case 4116:
			game = new String("Quake II");
			break;
		case 4117:
			game = new String("Legends of Mir II");
			break;
		case 4118:
			game = new String("Final Fantasy XI Online");
			break;
		case 4119:
			game = new String("Call of Duty Single Player");
			break;
		case 4120:
			game = new String("Call of Duty Multiplayer");
			break;
		case 4121:
			game = new String("Star Wars Knights of the Old Republic");
			break;
		case 4122:
			game = new String("Need For Speed: Underground");
			break;
		case 4123:
			game = new String("RollerCoaster Tycoon 2");
			break;
		case 4124:
			game = new String("Age of Empires II");
			break;
		case 4125:
			game = new String("Savage: The Battle for Newerth");
			break;
		case 4126:
			game = new String("Civilization III");
			break;
		case 4127:
			game = new String("SimCity 4");
			break;
		case 4128:
			game = new String("C&C Red Alert 2");
			break;
		case 4129:
			game = new String("C&C Generals");
			break;
		case 4130:
			game = new String("Gunbound");
			break;
		case 4131:
			game = new String("Fallout Tactics");
			break;
		case 4132:
			game = new String("Age of Wonders: Shadow Magic");
			break;
		case 4133:
			game = new String("Warlords IV: Heroes of Etheria");
			break;
		case 4134:
			game = new String("PartyPoker.com");
			break;
		case 4135:
			game = new String("Rise of Nations");
			break;
		case 4136:
			game = new String("Tribes 2");
			break;
		case 4137:
			game = new String("Unreal II XMP");
			break;
		case 4138:
			game = new String("Unreal II: The Awakening SP");
			break;
		case 4139:
			game = new String("Age of Mythology");
			break;
		case 4140:
			game = new String("Age of Mythology - The Titans Expansion");
			break;
		case 4141:
			game = new String("Raven Shield");
			break;
		case 4142:
			game = new String("Madden NFL 2004");
			break;
		case 4143:
			game = new String("Tiger Woods PGA Tour 2004");
			break;
		case 4144:
			game = new String("Civilization III Conquests");
			break;
		case 4145:
			game = new String("Civilization III Play the World");
			break;
		case 4146:
			game = new String("FIFA 2003");
			break;
		case 4147:
			game = new String("Spider Solitaire");
			break;
		case 4148:
			game = new String("Solitaire");
			break;
		case 4149:
			game = new String("Minesweeper");
			break;
		case 4150:
			game = new String("Medal of Honor Allied Assault - Breakthrough");
			break;
		case 4151:
			game = new String("Soldier of Fortune II Multiplayer");
			break;
		case 4152:
			game = new String("Medal of Honor Allied Assault - Spearhead");
			break;
		case 4153:
			game = new String("Soldier of Fortune II Single Player");
			break;
		case 4154:
			game = new String("Ghost Recon");
			break;
		case 4155:
			game = new String("Delta Force Black Hawk Down");
			break;
		case 4156:
			game = new String("C&C Generals - Zero Hour");
			break;
		case 4157:
			game = new String(
					"Star Wars Jedi Knight: Jedi Academy Single Player");
			break;
		case 4158:
			game = new String("Star Wars Jedi Knight: Jedi Academy Multiplayer");
			break;
		case 4159:
			game = new String("Silent Storm");
			break;
		case 4160:
			game = new String("Jedi Knight II Multiplayer");
			break;
		case 4161:
			game = new String("Jedi Knight II Single Player");
			break;
		case 4162:
			game = new String("Unreal Tournament 2004 Demo");
			break;
		case 4163:
			game = new String("Savage: The Battle for Newerth DEMO 2.0");
			break;
		case 4164:
			game = new String("Natural Selection");
			break;
		case 4165:
			game = new String("Day of Defeat 1.3");
			break;
		case 4166:
			game = new String("Deathmatch Classic (Steam)");
			break;
		case 4167:
			game = new String("Half-Life (Steam)");
			break;
		case 4168:
			game = new String("Opposing Force (Steam)");
			break;
		case 4169:
			game = new String("Ricochet (Steam)");
			break;
		case 4170:
			game = new String("Team Fortress Classic (Steam)");
			break;
		case 4171:
			game = new String("Vietcong");
			break;
		case 4172:
			game = new String("Aliens vs. Predator 2");
			break;
		case 4173:
			game = new String("Return to Castle Wolfenstein Single Player");
			break;
		case 4174:
			game = new String("Return to Castle Wolfenstein Multiplayer");
			break;
		case 4175:
			game = new String("Dark Age of Camelot - Trials of Atlantis");
			break;
		case 4176:
			game = new String("Tron 2.0");
			break;
		case 4177:
			game = new String("Red Faction II");
			break;
		case 4178:
			game = new String("C&C Renegade");
			break;
		case 4179:
			game = new String("Second Life");
			break;
		case 4180:
			game = new String("Far Cry");
			break;
		case 4181:
			game = new String("Unreal Tournament 2004");
			break;
		case 4182:
			game = new String("Battlefield Vietnam");
			break;
		case 4183:
			game = new String("Soldat");
			break;
		case 4184:
			game = new String("Combat Flight Simulator 3");
			break;
		case 4185:
			game = new String("Midnight Club 2");
			break;
		case 4186:
			game = new String("Counter-Strike 1.5");
			break;
		case 4187:
			game = new String("Counter-Strike: Condition Zero");
			break;
		case 4188:
			game = new String("Carom 3D");
			break;
		case 4189:
			game = new String("The Specialists");
			break;
		case 4190:
			game = new String("Star Trek Elite Force II");
			break;
		case 4191:
			game = new String("NetGammon");
			break;
		case 4192:
			game = new String("Empire Earth");
			break;
		case 4193:
			game = new String("Condition Zero: Deleted Scenes");
			break;
		case 4194:
			game = new String("Splinter Cell Pandora Tomorrow Single Player");
			break;
		case 4195:
			game = new String("Splinter Cell Pandora Tomorrow Multiplayer");
			break;
		case 4196:
			game = new String("Chrome MP Demo 2004");
			break;
		case 4197:
			game = new String("Ragnarok Online");
			break;
		case 4198:
			game = new String("Breed");
			break;
		case 4393:
			game = new String("Painkiller Battle out of Hell");
			break;
		case 4199:
			game = new String("Painkiller");
			break;
		case 4200:
			game = new String("Chrome");
			break;
		case 4201:
			game = new String("Lock On");
			break;
		case 4202:
			game = new String("Sacred");
			break;
		case 4203:
			game = new String("Tactical Ops");
			break;
		case 4204:
			game = new String("Starsiege Tribes");
			break;
		case 4205:
			game = new String("NASCAR Racing 3");
			break;
		case 4206:
			game = new String("NASCAR Racing 4");
			break;
		case 4207:
			game = new String("NASCAR Racing 2003 Season");
			break;
		case 4208:
			game = new String("Star Trek Voyager: Elite Force Multiplayer");
			break;
		case 4209:
			game = new String("Star Trek Armada");
			break;
		case 4210:
			game = new String("Universal Combat Single Player");
			break;
		case 4211:
			game = new String("Universal Combat Multiplayer");
			break;
		case 4212:
			game = new String("Operation Flashpoint");
			break;
		case 4213:
			game = new String("Operation Flashpoint Resistance");
			break;
		case 4214:
			game = new String("IL-2 Sturmovik Collection");
			break;
		case 4215:
			game = new String("Lineage II");
			break;
		case 4216:
			game = new String("World of Warcraft");
			break;
		case 4217:
			game = new String("City of Heroes");
			break;
		case 4218:
			game = new String("Rise of Nations - Thrones & Patriots");
			break;
		case 4219:
			game = new String("Manhunt");
			break;
		case 4220:
			game = new String("Hitman 2 - Silent Assassin");
			break;
		case 4221:
			game = new String("Hitman Contracts");
			break;
		case 4222:
			game = new String("Iron Storm");
			break;
		case 4223:
			game = new String("Rogue Spear");
			break;
		case 4224:
			game = new String("Rogue Spear - Urban Operations");
			break;
		case 4225:
			game = new String("Star Trek Voyager: Elite Force Single Player");
			break;
		case 4226:
			game = new String("Asheron's Call 2");
			break;
		case 4227:
			game = new String("Legends of Mir III");
			break;
		case 4228:
			game = new String("JX Online");
			break;
		case 4229:
			game = new String("Karma Online");
			break;
		case 4230:
			game = new String("Legends of Mir");
			break;
		case 4231:
			game = new String("Mu Online");
			break;
		case 4232:
			game = new String("Prince of Qin Online");
			break;
		case 4233:
			game = new String("The World of Legend");
			break;
		case 4234:
			game = new String("Soldner Beta Demo");
			break;
		case 4235:
			game = new String("GLQuake");
			break;
		case 4236:
			game = new String("QuakeWorld");
			break;
		case 4237:
			game = new String("There");
			break;
		case 4238:
			game = new String("Red Faction");
			break;
		case 4239:
			game = new String("Halo Custom Edition");
			break;
		case 4240:
			game = new String("Freelancer");
			break;
		case 4241:
			game = new String("Deus Ex");
			break;
		case 4242:
			game = new String("True Crime - Streets of LA");
			break;
		case 4243:
			game = new String("The Saga of Ryzom");
			break;
		case 4244:
			game = new String("Shadowbane");
			break;
		case 4245:
			game = new String("MechWarrior 4 Vengeance");
			break;
		case 4246:
			game = new String("MechWarrior Mercenaries");
			break;
		case 4247:
			game = new String("Serious Sam - The Second Encounter");
			break;
		case 4248:
			game = new String("Joint Operations: Typhoon Rising");
			break;
		case 4249:
			game = new String("Thief - Deadly Shadows");
			break;
		case 4250:
			game = new String("Rune");
			break;
		case 4251:
			game = new String("GetAmped");
			break;
		case 4252:
			game = new String("Mabinogi");
			break;
		case 4253:
			game = new String("Priston Tale");
			break;
		case 4254:
			game = new String("Istaria: Chronicles of the Gifted");
			break;
		case 4255:
			game = new String("Ultima Online");
			break;
		case 4256:
			game = new String("Hidden & Dangerous");
			break;
		case 4257:
			game = new String("Hidden & Dangerous 2");
			break;
		case 4258:
			game = new String("C&C Yuri's Revenge");
			break;
		case 4259:
			game = new String("Empires Dawn of the Modern World");
			break;
		case 4260:
			game = new String("Medieval - Total War");
			break;
		case 4261:
			game = new String("Soldner - Secret Wars");
			break;
		case 4262:
			game = new String("A3");
			break;
		case 4263:
			game = new String("John Deere American Farmer");
			break;
		case 4264:
			game = new String("MapleStory");
			break;
		case 4265:
			game = new String("GunZ: The Duel");
			break;
		case 4266:
			game = new String("Grand Theft Auto III");
			break;
		case 4267:
			game = new String("Grand Theft Auto: Vice City");
			break;
		case 4268:
			game = new String("MameUI");
			break;
		case 4269:
			game = new String("Tony Hawk's Pro Skater 3");
			break;
		case 4270:
			game = new String("Warcraft III - The Frozen Throne");
			break;
		case 4271:
			game = new String("Doom 3");
			break;
		case 4272:
			game = new String("Tony Hawk's Pro Skater 4");
			break;
		case 4273:
			game = new String("Toca Race Driver 2");
			break;
		case 4274:
			game = new String("Vietcong Fist Alpha");
			break;
		case 4275:
			game = new String("Rainbow Six 3 - Athena Sword");
			break;
		case 4276:
			game = new String("Half-Life 1.5");
			break;
		case 4277:
			game = new String("Day of Defeat 1.5");
			break;
		case 4278:
			game = new String("Team Fortress Classic 1.5");
			break;
		case 4279:
			game = new String("Opposing Force 1.5");
			break;
		case 4280:
			game = new String("Deathmatch Classic 1.5");
			break;
		case 4281:
			game = new String("Ricochet 1.5");
			break;
		case 4282:
			game = new String("Red Orchestra");
			break;
		case 4283:
			game = new String("Ground Control II");
			break;
		case 4286:
			game = new String("Take-Out Weight Curling");
			break;
		case 4287:
			game = new String("Take-Out Weight Curling 2");
			break;
		case 4288:
			game = new String("Delta Force");
			break;
		case 4289:
			game = new String("Delta Force 2");
			break;
		case 4290:
			game = new String("XIII");
			break;
		case 4291:
			game = new String("SpellForce - The Order of Dawn");
			break;
		case 4292:
			game = new String("Gore - Ultimate Soldier");
			break;
		case 4293:
			game = new String("The Sims");
			break;
		case 4294:
			game = new String("Max Payne 2");
			break;
		case 4295:
			game = new String("Codename Gordon");
			break;
		case 4296:
			game = new String("Earth's Special Forces");
			break;
		case 4297:
			game = new String("Digital Paintball");
			break;
		case 4298:
			game = new String("Firearms");
			break;
		case 4299:
			game = new String("Sven Co-op");
			break;
		case 4300:
			game = new String("Warhammer 40,000 Dawn of War Beta");
			break;
		case 4301:
			game = new String("Frag Ops");
			break;
		case 4302:
			game = new String("Troopers: Dawn of Destiny");
			break;
		case 4303:
			game = new String("Counter-Strike: Source (Beta)");
			break;
		case 4304:
			game = new String("Medal of Honor Pacific Assault");
			break;
		case 4305:
			game = new String("No One Lives Forever 2");
			break;
		case 4306:
			game = new String("4x4 Evolution");
			break;
		case 4307:
			game = new String("Max Payne");
			break;
		case 4308:
			game = new String("SimCity 3000 Unlimited");
			break;
		case 4309:
			game = new String(
					"The Lord of the Rings - The Battle for Middle-Earth");
			break;
		case 4310:
			game = new String("Call of Duty United Offensive Single Player");
			break;
		case 4311:
			game = new String("Call of Duty United Offensive Multiplayer");
			break;
		case 4312:
			game = new String("The Elder Scrolls III: Morrowind");
			break;
		case 4313:
			game = new String("Warlords Battlecry III");
			break;
		case 4314:
			game = new String("Colin Mcrae Rally 04");
			break;
		case 4315:
			game = new String("MotoGP 2");
			break;
		case 4316:
			game = new String("Unreal");
			break;
		case 4317:
			game = new String("Nox");
			break;
		case 4318:
			game = new String("Total Annihilation Kingdoms");
			break;
		case 4319:
			game = new String("Tribes Vengeance Multiplayer Demo");
			break;
		case 4320:
			game = new String("Eve Online");
			break;
		case 4321:
			game = new String("EverQuest II Beta");
			break;
		case 4322:
			game = new String("The Sims 2");
			break;
		case 4323:
			game = new String("Star Wars Battlefront");
			break;
		case 4324:
			game = new String("Dawn of War");
			break;
		case 4325:
			game = new String("Rome: Total War");
			break;
		case 4326:
			game = new String(
					"Call of Duty United Offensive Single Player Demo");
			break;
		case 4327:
			game = new String("Anarchy Online");
			break;
		case 4328:
			game = new String("Full Spectrum Warrior");
			break;
		case 4329:
			game = new String("Kohan II Kings of War");
			break;
		case 4330:
			game = new String("Tribes Vengeance");
			break;
		case 4331:
			game = new String("Counter-Strike: Source");
			break;
		case 4332:
			game = new String(
					"Star Wars Galaxies - The Jump to Lightspeed Beta");
			break;
		case 4333:
			game = new String("Gotcha!");
			break;
		case 4334:
			game = new String("Leisure Suit Larry - Magna Cum Laude");
			break;
		case 4335:
			game = new String("Stepmania CVS");
			break;
		case 4336:
			game = new String("Trackmania");
			break;
		case 4337:
			game = new String("Tony Hawk's Underground 2");
			break;
		case 4338:
			game = new String("Dawn of War Demo");
			break;
		case 4339:
			game = new String("Men of Valor MP Demo");
			break;
		case 4340:
			game = new String("Madden NFL 2005");
			break;
		case 4341:
			game = new String("Tiger Woods PGA Tour 2005");
			break;
		case 4342:
			game = new String("NHL 2005");
			break;
		case 4343:
			game = new String("Evil Genius");
			break;
		case 4621:
			game = new String("RollerCoaster Tycoon 3 Soaked");
			break;
		case 4693:
			game = new String("RollerCoaster Tycoon 3 Wild");
			break;
		case 4344:
			game = new String("RollerCoaster Tycoon 3");
			break;
		case 4345:
			game = new String("Guild Wars");
			break;
		case 4346:
			game = new String("Medal of Honor Pacific Assault MP Demo");
			break;
		case 4347:
			game = new String("Axis & Allies");
			break;
		case 4348:
			game = new String("The Simpsons Hit & Run");
			break;
		case 4349:
			game = new String("ShellShock Nam67");
			break;
		case 4350:
			game = new String("Deus Ex Invisible War");
			break;
		case 4351:
			game = new String("Kingpin Life of Crime");
			break;
		case 4352:
			game = new String("EverQuest II");
			break;
		case 4353:
			game = new String("Need for Speed: Underground 2");
			break;
		case 4354:
			game = new String("FIFA Soccer 2005");
			break;
		case 4355:
			game = new String("NBA Live 2005");
			break;
		case 4356:
			game = new String("Flight Simulator 2004");
			break;
		case 4357:
			game = new String("Half-Life 2");
			break;
		case 4358:
			game = new String("Half-Life: Source");
			break;
		case 4359:
			game = new String("Sid Meier's Pirates!");
			break;
		case 4360:
			game = new String("Joint Operations: Escalation");
			break;
		case 4361:
			game = new String("Hidden & Dangerous 2 Sabre Squadron");
			break;
		case 4362:
			game = new String("Vampire - The Masquerade Bloodlines");
			break;
		case 4363:
			game = new String("Half-Life 2: Deathmatch");
			break;
		case 5670:
			game = new String("Zoo Tycoon 2: Ultimate Collection");
			break;
		case 5457:
			game = new String("Zoo Tycoon 2: Extinct Animals");
			break;
		case 4933:
			game = new String("Zoo Tycoon 2: Marine Mania");
			break;
		case 4839:
			game = new String("Zoo Tycoon 2 African Adventure");
			break;
		case 4704:
			game = new String("Zoo Tycoon 2: Endangered Species");
			break;
		case 4364:
			game = new String("Zoo Tycoon 2");
			break;
		case 4365:
			game = new String("Prince of Persia Warrior Within");
			break;
		case 4366:
			game = new String("Men of Valor");
			break;
		case 4367:
			game = new String("Worms 3D");
			break;
		case 4368:
			game = new String(
					"The Chronicles of Riddick: Escape from Butcher Bay");
			break;
		case 4369:
			game = new String("System Shock 2");
			break;
		case 4370:
			game = new String("Armed and Dangerous");
			break;
		case 4371:
			game = new String("Armies of Exigo");
			break;
		case 4372:
			game = new String("Codename: Panzers, Phase 1");
			break;
		case 4373:
			game = new String("Dungeon Siege Legends of Aranna");
			break;
		case 4374:
			game = new String("SAS Into the Lion's Den");
			break;
		case 4375:
			game = new String("Action Unreal Tournament 2004");
			break;
		case 4376:
			game = new String("Age of Empires II: The Conquerors Expansion");
			break;
		case 4377:
			game = new String("Kill.Switch");
			break;
		case 4378:
			game = new String("Soldier of Fortune");
			break;
		case 4379:
			game = new String("Risk Your Life");
			break;
		case 4380:
			game = new String("Jedi Knight");
			break;
		case 4381:
			game = new String("No One Lives Forever");
			break;
		case 4636:
			game = new String("C&C Tiberian Sun Firestorm");
			break;
		case 4382:
			game = new String("C&C Tiberian Sun");
			break;
		case 4383:
			game = new String("Knight Online");
			break;
		case 4384:
			game = new String("Star Wars Galactic Battlegrounds");
			break;
		case 4385:
			game = new String(
					"Star Wars Galactic Battlegrounds - Clone Campaigns");
			break;
		case 4386:
			game = new String(
					"Star Wars Knights of the Old Republic II: The Sith Lords");
			break;
		case 4387:
			game = new String("Armies of Exigo Single Player Demo");
			break;
		case 4388:
			game = new String("Homeworld");
			break;
		case 4389:
			game = new String("Homeworld 2");
			break;
		case 4390:
			game = new String("Warcraft II");
			break;
		case 4391:
			game = new String("Wulfram 2");
			break;
		case 4392:
			game = new String("ProQuake");
			break;
		case 4394:
			game = new String("R.O.S.E. Online Evolution");
			break;
		case 4395:
			game = new String("Dark Age of Camelot - Catacombs");
			break;
		case 4396:
			game = new String("Splinter Cell Chaos Theory Versus Beta");
			break;
		case 4397:
			game = new String("Worms Armageddon");
			break;
		case 4398:
			game = new String("Battlefield 2 Demo");
			break;
		case 4399:
			game = new String("Star Wars Republic Commando Demo");
			break;
		case 4400:
			game = new String("The Punisher");
			break;
		case 4401:
			game = new String("Postal 2 Share the Pain");
			break;
		case 4402:
			game = new String("SWAT 4 MP Beta");
			break;
		case 4403:
			game = new String("Winning Eleven 7 INTERNATIONAL");
			break;
		case 4404:
			game = new String("The Settlers: Heritage of Kings Demo");
			break;
		case 4405:
			game = new String("City of Heroes EU");
			break;
		case 4406:
			game = new String("Hearts of Iron II");
			break;
		case 4407:
			game = new String("R.Y.L. Path of the Emperor");
			break;
		case 4408:
			game = new String("Splinter Cell Chaos Theory Single Player Demo");
			break;
		case 4409:
			game = new String("4x4 Evo2");
			break;
		case 4410:
			game = new String("Star Wars Republic Commando");
			break;
		case 4411:
			game = new String("The Sims 2 University");
			break;
		case 4412:
			game = new String("Freedom Force vs The 3rd Reich");
			break;
		case 4413:
			game = new String("Black & White");
			break;
		case 4414:
			game = new String("The Matrix Online");
			break;
		case 4415:
			game = new String("NASCAR SimRacing");
			break;
		case 4416:
			game = new String("Brothers in Arms");
			break;
		case 4417:
			game = new String("FlatOut");
			break;
		case 4418:
			game = new String("Silent Hunter III");
			break;
		case 4419:
			game = new String("Nexus - The Jupiter Incident");
			break;
		case 4420:
			game = new String("Act of War: Direct Action");
			break;
		case 4421:
			game = new String("Prince of Persia - The Sands of Time");
			break;
		case 4422:
			game = new String("Colin Mcrae Rally 05");
			break;
		case 4423:
			game = new String("Playboy - The Mansion");
			break;
		case 4424:
			game = new String("Splinter Cell Chaos Theory Single Player");
			break;
		case 4425:
			game = new String("Splinter Cell Chaos Theory Multiplayer");
			break;
		case 4426:
			game = new String("Giants: Citizen Kabuto");
			break;
		case 4427:
			game = new String("Icewind Dale");
			break;
		case 4428:
			game = new String("Icewind Dale - Heart of Winter");
			break;
		case 4429:
			game = new String("Doom 3 Resurrection of Evil");
			break;
		case 4430:
			game = new String("Darwinia Demo");
			break;
		case 4431:
			game = new String("Darwinia");
			break;
		case 4432:
			game = new String("SWAT 4");
			break;
		case 4433:
			game = new String("Worms World Party");
			break;
		case 4434:
			game = new String("Driv3r");
			break;
		case 4435:
			game = new String("Gaming Club Poker");
			break;
		case 4436:
			game = new String("Winning Eleven 8");
			break;
		case 4437:
			game = new String("Tropico");
			break;
		case 4438:
			game = new String("Tropico 2 Pirate Cove");
			break;
		case 4439:
			game = new String("Kal Online");
			break;
		case 4440:
			game = new String("Project Snowblind Single Player");
			break;
		case 4441:
			game = new String("Splinter Cell");
			break;
		case 4442:
			game = new String("Grand Theft Auto 2");
			break;
		case 4443:
			game = new String("Caesar 3");
			break;
		case 4444:
			game = new String("Pharaoh");
			break;
		case 4445:
			game = new String("Lego Star Wars");
			break;
		case 4446:
			game = new String("Close Combat First to Fight");
			break;
		case 4447:
			game = new String("Empire Earth II");
			break;
		case 4448:
			game = new String("Stronghold 2");
			break;
		case 4449:
			game = new String("The Settlers: Heritage of Kings");
			break;
		case 4450:
			game = new String("Delta Force Xtreme");
			break;
		case 4451:
			game = new String("StillLife");
			break;
		case 4452:
			game = new String("Dungeon Siege II Demo");
			break;
		case 4553:
			game = new String("Psychonauts");
			break;
		case 4554:
			game = new String("GTR");
			break;
		case 4555:
			game = new String("Pariah");
			break;
		case 4556:
			game = new String("Psychotoxic");
			break;
		case 4557:
			game = new String("Immortal Cities: Children of The Nile");
			break;
		case 4558:
			game = new String("Championship Manager 5");
			break;
		case 4559:
			game = new String("Football Manager 2005");
			break;
		case 4560:
			game = new String("Total Club Manager 2005");
			break;
		case 4561:
			game = new String("Soldiers - Heroes of World War II");
			break;
		case 4562:
			game = new String("Plan of Attack");
			break;
		case 4563:
			game = new String("Total Annihilation");
			break;
		case 4564:
			game = new String("Pro Evolution Soccer 4");
			break;
		case 4565:
			game = new String("Age of Empires");
			break;
		case 4566:
			game = new String("Trackmania Sunrise");
			break;
		case 4567:
			game = new String("PokerStars.com");
			break;
		case 4568:
			game = new String("PokerRoom.com");
			break;
		case 4569:
			game = new String("EmpirePoker.com");
			break;
		case 4570:
			game = new String("TruePoker.com");
			break;
		case 4571:
			game = new String("Project Snowblind Multiplayer");
			break;
		case 5731:
			game = new String("Grand Theft Auto: San Andreas Multiplayer");
			break;
		case 4572:
			game = new String("Grand Theft Auto: San Andreas");
			break;
		case 4573:
			game = new String("Cossacks II");
			break;
		case 4574:
			game = new String("Serious Sam");
			break;
		case 4575:
			game = new String("Universal Combat AWA Single Player");
			break;
		case 4576:
			game = new String("Universal Combat AWA Multiplayer");
			break;
		case 4577:
			game = new String("Imperial Glory");
			break;
		case 4578:
			game = new String("Battlefield 2");
			break;
		case 4579:
			game = new String("18 Wheels of Steel Pedal to the Metal");
			break;
		case 4580:
			game = new String("Area 51");
			break;
		case 4581:
			game = new String("Universal Combat Gold Single Player");
			break;
		case 4582:
			game = new String("Universal Combat Gold Multiplayer");
			break;
		case 4583:
			game = new String("Mojo Master");
			break;
		case 4584:
			game = new String("Juiced");
			break;
		case 4585:
			game = new String("Zoo Tycoon");
			break;
		case 4586:
			game = new String("Need for Speed II SE");
			break;
		case 4587:
			game = new String("Need for Speed: High Stakes");
			break;
		case 4588:
			game = new String("Need for Speed III: Hot Pursuit");
			break;
		case 4589:
			game = new String("Need for Speed: Porsche Unleashed");
			break;
		case 4590:
			game = new String("Need for Speed: Hot Pursuit 2");
			break;
		case 4591:
			game = new String("Half-Life 2: Capture the Flag");
			break;
		case 4592:
			game = new String("Half-Life 2: Substance");
			break;
		case 4593:
			game = new String("Garry's Mod");
			break;
		case 4594:
			game = new String("CounterStrike 2D");
			break;
		case 4595:
			game = new String("Continuum");
			break;
		case 4596:
			game = new String("Mafia");
			break;
		case 4597:
			game = new String("Cold Fear");
			break;
		case 4598:
			game = new String("COR");
			break;
		case 4599:
			game = new String("Silent Hill 2");
			break;
		case 4600:
			game = new String("Silent Hill 3");
			break;
		case 4601:
			game = new String("Silent Hill 4");
			break;
		case 4602:
			game = new String("Baldur's Gate");
			break;
		case 4603:
			game = new String("X-Wing vs. TIE Fighter");
			break;
		case 4604:
			game = new String("Stronghold");
			break;
		case 4605:
			game = new String("Stronghold Crusader");
			break;
		case 4606:
			game = new String("Gothic II");
			break;
		case 4607:
			game = new String("The Sims Online");
			break;
		case 4608:
			game = new String("Magic Online");
			break;
		case 4609:
			game = new String("Thief");
			break;
		case 4610:
			game = new String("Thief 2 The Metal Age");
			break;
		case 4611:
			game = new String("Live for Speed");
			break;
		case 4612:
			game = new String("Spartan");
			break;
		case 4613:
			game = new String("Gates of Troy");
			break;
		case 4614:
			game = new String("Age of Empires: The Rise of Rome");
			break;
		case 4615:
			game = new String("Sudden Strike II");
			break;
		case 4616:
			game = new String("Scrapland");
			break;
		case 4617:
			game = new String("Mortyr 2");
			break;
		case 4618:
			game = new String("Homeworld Cataclysm");
			break;
		case 4619:
			game = new String("Fate");
			break;
		case 4620:
			game = new String("Dungeon Siege II");
			break;
		case 4622:
			game = new String("Blue Shift");
			break;
		case 4623:
			game = new String("Control Monger");
			break;
		case 4624:
			game = new String("FEAR SP Demo");
			break;
		case 4625:
			game = new String("Madden NFL 2006");
			break;
		case 4626:
			game = new String("The Bard's Tale");
			break;
		case 4627:
			game = new String("Half-Life: Blue Shift (Steam)");
			break;
		case 4628:
			game = new String("Legion Arena");
			break;
		case 4629:
			game = new String("NTE");
			break;
		case 4630:
			game = new String("Grim Fandango");
			break;
		case 4631:
			game = new String("1602 A.D.");
			break;
		case 4632:
			game = new String("Conquer Online");
			break;
		case 4633:
			game = new String("Age of Empires III Trial");
			break;
		case 4634:
			game = new String("Dystopia");
			break;
		case 4635:
			game = new String("Toontown Online");
			break;
		case 4637:
			game = new String("Serious Sam 2 Demo");
			break;
		case 4638:
			game = new String("Fallout");
			break;
		case 4639:
			game = new String("Fallout 2");
			break;
		case 4640:
			game = new String("Superpower 2");
			break;
		case 4641:
			game = new String("Enter the Matrix");
			break;
		case 4642:
			game = new String("Rollercoaster Tycoon");
			break;
		case 4643:
			game = new String("Railroad Tycoon 3");
			break;
		case 4644:
			game = new String("Codename: Panzers, Phase 2");
			break;
		case 4645:
			game = new String("Blitzkrieg");
			break;
		case 4646:
			game = new String("NHL 06");
			break;
		case 4647:
			game = new String("MVP Baseball 2005");
			break;
		case 4648:
			game = new String("Fable - The Lost Chapters");
			break;
		case 4649:
			game = new String("Dawn of War Winter Assault");
			break;
		case 4650:
			game = new String("Beats of Rage");
			break;
		case 4651:
			game = new String("Tiger Woods PGA Tour 06");
			break;
		case 4652:
			game = new String("The Sims 2 Nightlife");
			break;
		case 4653:
			game = new String("Day of Defeat: Source");
			break;
		case 4654:
			game = new String("Sacred Underworld");
			break;
		case 4655:
			game = new String("Star Wars Battlefront II");
			break;
		case 4656:
			game = new String("Call of Duty 2 Single Player Demo");
			break;
		case 4657:
			game = new String("Brothers in Arms EIB Demo");
			break;
		case 4658:
			game = new String("FEAR Multiplayer Demo");
			break;
		case 4659:
			game = new String("Rome: Total War: Barbarian Invasion");
			break;
		case 4660:
			game = new String("Dragonshard");
			break;
		case 4661:
			game = new String("Brothers in Arms EIB");
			break;
		case 4662:
			game = new String("Serious Sam 2");
			break;
		case 4663:
			game = new String("Black & White 2");
			break;
		case 4664:
			game = new String("FIFA Soccer 06");
			break;
		case 4665:
			game = new String("NBA Live 06");
			break;
		case 4666:
			game = new String("Rag Doll Kung Fu");
			break;
		case 4667:
			game = new String("FEAR Single Player");
			break;
		case 4668:
			game = new String("MotoGP URT 3");
			break;
		case 4669:
			game = new String("Ultimate Spider-Man");
			break;
		case 4670:
			game = new String("X-Men Legends 2");
			break;
		case 4671:
			game = new String("Blitzkrieg 2");
			break;
		case 4672:
			game = new String("18 Wheels of Steel Convoy");
			break;
		case 4673:
			game = new String("Gangland");
			break;
		case 4674:
			game = new String("Risk II");
			break;
		case 4675:
			game = new String("Bet on Soldier");
			break;
		case 4676:
			game = new String("Descent FreeSpace");
			break;
		case 4677:
			game = new String("Prison Tycoon");
			break;
		case 4678:
			game = new String("Quake 4");
			break;
		case 4679:
			game = new String("Age of Empires III");
			break;
		case 4680:
			game = new String("Richard Burns Rally");
			break;
		case 4681:
			game = new String("Indigo Prophecy");
			break;
		case 4682:
			game = new String("Vietcong 2");
			break;
		case 4683:
			game = new String("Call of Duty 2 Single Player");
			break;
		case 4684:
			game = new String("Call of Duty 2 Multiplayer");
			break;
		case 4685:
			game = new String("Civilization IV");
			break;
		case 4686:
			game = new String("LOTR Return of the King");
			break;
		case 4687:
			game = new String("City of Villains");
			break;
		case 4688:
			game = new String("Heroes of the Pacific");
			break;
		case 4689:
			game = new String("Fahrenheit");
			break;
		case 4690:
			game = new String("City of Villains EU");
			break;
		case 4691:
			game = new String("Shattered Union");
			break;
		case 4692:
			game = new String("X2 - The Threat");
			break;
		case 4694:
			game = new String("Half-Life 2: Lost Coast");
			break;
		case 4695:
			game = new String("Gun");
			break;
		case 4696:
			game = new String("The Movies");
			break;
		case 4697:
			game = new String("The Matrix - The Path of Neo");
			break;
		case 4698:
			game = new String("Contract JACK");
			break;
		case 4699:
			game = new String("BloodRayne");
			break;
		case 4700:
			game = new String("BloodRayne 2");
			break;
		case 4701:
			game = new String("Sourceforts");
			break;
		case 4702:
			game = new String("Need for Speed: Most Wanted");
			break;
		case 4703:
			game = new String("John Deere North American Farmer");
			break;
		case 4705:
			game = new String("Worms 4 Mayhem");
			break;
		case 4706:
			game = new String("Earth 2160");
			break;
		case 4707:
			game = new String("Sniper Elite");
			break;
		case 4708:
			game = new String("Peter Jackson's King Kong");
			break;
		case 4709:
			game = new String("Crime Life");
			break;
		case 4710:
			game = new String("Empire Earth II Art of Supremacy");
			break;
		case 4711:
			game = new String("Quake 4 Demo");
			break;
		case 4712:
			game = new String("Silkroad Online");
			break;
		case 4713:
			game = new String("Flyff");
			break;
		case 4714:
			game = new String("Prince of Persia The Two Thrones");
			break;
		case 4715:
			game = new String("WarRock");
			break;
		case 4716:
			game = new String("X3 - The Reunion");
			break;
		case 4717:
			game = new String("Stubbs the Zombie");
			break;
		case 4718:
			game = new String("Pro Evolution Soccer 5");
			break;
		case 4719:
			game = new String("Football Manager 2006");
			break;
		case 4720:
			game = new String("Star Trek Bridge Commander");
			break;
		case 4721:
			game = new String("Advent Rising");
			break;
		case 4722:
			game = new String("UFO Aftershock");
			break;
		case 4723:
			game = new String("NavyField");
			break;
		case 4724:
			game = new String("Rubies of Eventide");
			break;
		case 4725:
			game = new String("FIFA Manager 06");
			break;
		case 4726:
			game = new String("Star Wars Empire at War");
			break;
		case 4727:
			game = new String("Metal Gear Solid2 Substance");
			break;
		case 4728:
			game = new String("KumaWar");
			break;
		case 4729:
			game = new String("Heroes of Might and Magic III");
			break;
		case 4730:
			game = new String(
					"Heroes of Might and Magic III Armageddon's Blade");
			break;
		case 4731:
			game = new String("Rakion Chaos Force");
			break;
		case 4732:
			game = new String("Midtown Madness");
			break;
		case 4733:
			game = new String("Midtown Madness 2");
			break;
		case 4734:
			game = new String("Monster Truck Madness 2");
			break;
		case 4735:
			game = new String("Motocross Madness 2");
			break;
		case 4736:
			game = new String("Rainbow Six Lockdown Demo");
			break;
		case 4737:
			game = new String("Star Wars Empire at War Demo");
			break;
		case 4738:
			game = new String("Final Fantasy VII");
			break;
		case 4739:
			game = new String("Final Fantasy VIII");
			break;
		case 4740:
			game = new String("Battle for Middle-earth II Beta");
			break;
		case 4741:
			game = new String("Heroes of Might and Magic V Beta");
			break;
		case 4742:
			game = new String("MX vs ATV Unleashed Demo");
			break;
		case 4743:
			game = new String("FSW Ten Hammers");
			break;
		case 4744:
			game = new String("MX vs ATV Unleashed");
			break;
		case 4745:
			game = new String("Freecell");
			break;
		case 4746:
			game = new String("Hearts");
			break;
		case 4747:
			game = new String("Pinball");
			break;
		case 4748:
			game = new String("Devastation");
			break;
		case 4749:
			game = new String("Heroes of Might and Magic IV");
			break;
		case 4750:
			game = new String("Rainbow Six Lockdown");
			break;
		case 4751:
			game = new String(
					"Marc Ecko's Getting Up - Contents Under Pressure");
			break;
		case 4752:
			game = new String("GT Legends");
			break;
		case 4753:
			game = new String("Trackmania Nations");
			break;
		case 4754:
			game = new String("C&C Red Alert");
			break;
		case 4755:
			game = new String("Command & Conquer");
			break;
		case 4756:
			game = new String("SpaceCowboy");
			break;
		case 4757:
			game = new String("Battle for Middle-earth II");
			break;
		case 4758:
			game = new String("Toca Race Driver 3");
			break;
		case 4759:
			game = new String("RF Online");
			break;
		case 4760:
			game = new String("Cabela's Big Game Hunter 2006");
			break;
		case 4761:
			game = new String("Deer Hunter 2003");
			break;
		case 4762:
			game = new String("Deer Hunter 2004");
			break;
		case 4763:
			game = new String("Deer Hunter 2005");
			break;
		case 4764:
			game = new String("Myst");
			break;
		case 4765:
			game = new String("Riven");
			break;
		case 4766:
			game = new String("Myst III Exile");
			break;
		case 4767:
			game = new String("Myst IV Revelation");
			break;
		case 4768:
			game = new String("Myst V End of Ages");
			break;
		case 4769:
			game = new String("Auto Assault");
			break;
		case 4770:
			game = new String("Dungeons & Dragons Online: Eberron Unlimited");
			break;
		case 4771:
			game = new String("The Sims 2 Open for Business");
			break;
		case 4772:
			game = new String("SWAT 4 - The Stetchkov Syndicate");
			break;
		case 4773:
			game = new String("NCAA Championship Run 2006");
			break;
		case 4774:
			game = new String("The Elder Scrolls IV: Oblivion");
			break;
		case 4775:
			game = new String("Dark Age of Camelot - Darkness Rising");
			break;
		case 4776:
			game = new String("The Godfather");
			break;
		case 4777:
			game = new String("Red Orchestra Ostfront 41-45 (Steam)");
			break;
		case 4778:
			game = new String("Galactic Civilizations II");
			break;
		case 4779:
			game = new String("Galactic Civilizations");
			break;
		case 4780:
			game = new String("Galactic Civilizations - The Altarian Prophecy");
			break;
		case 4781:
			game = new String("18 Wheels of Steel Across America");
			break;
		case 4782:
			game = new String("Sin (Steam)");
			break;
		case 4783:
			game = new String("Sin Multiplayer (Steam)");
			break;
		case 4784:
			game = new String("SpellForce2 - Shadow Wars");
			break;
		case 4785:
			game = new String("Commandos Strikeforce");
			break;
		case 4786:
			game = new String("Tomb Raider - Legend");
			break;
		case 4787:
			game = new String("The Sims 2 Family Fun Stuff");
			break;
		case 5591:
			game = new String("Sword of the Stars: A Murder of Crows");
			break;
		case 5439:
			game = new String("Sword of the Stars Collectors' Edition");
			break;
		case 4788:
			game = new String("Sword of the Stars");
			break;
		case 4789:
			game = new String("True Crime - New York City");
			break;
		case 4790:
			game = new String("Shattered Galaxy");
			break;
		case 4791:
			game = new String("WWII Online");
			break;
		case 4792:
			game = new String("Blazing Angels");
			break;
		case 4793:
			game = new String("Heroes of Might and Magic V Demo");
			break;
		case 4794:
			game = new String("Titan Quest Demo");
			break;
		case 4795:
			game = new String("Condemned - Criminal Origins");
			break;
		case 4796:
			game = new String("2006 FIFA World Cup");
			break;
		case 4797:
			game = new String("Dangerous Waters");
			break;
		case 4798:
			game = new String("Dune 2000");
			break;
		case 4799:
			game = new String("Emperor - Battle for Dune");
			break;
		case 4800:
			game = new String("Ghost Recon Advanced Warfighter Demo");
			break;
		case 4801:
			game = new String("Sid Meier's Alpha Centauri");
			break;
		case 4802:
			game = new String("Winning Eleven 9");
			break;
		case 4803:
			game = new String("Ghost Recon Advanced Warfighter");
			break;
		case 4804:
			game = new String("Call of Cthulhu DCoTE");
			break;
		case 4805:
			game = new String("The Settlers IV");
			break;
		case 4806:
			game = new String("Hearts of Iron II Doomsday");
			break;
		case 4807:
			game = new String("UberSoldier");
			break;
		case 4808:
			game = new String("Dungeon Keeper 2");
			break;
		case 4809:
			game = new String("Tycoon City - New York");
			break;
		case 4810:
			game = new String("Crashday");
			break;
		case 4811:
			game = new String("Titan Quest");
			break;
		case 4812:
			game = new String("Tony Hawk's American Wasteland");
			break;
		case 4813:
			game = new String("Rise of Legends");
			break;
		case 4814:
			game = new String("Sin Episodes - Emergence");
			break;
		case 4815:
			game = new String("Heroes of Might and Magic V");
			break;
		case 4816:
			game = new String("City of Heroes Test Server");
			break;
		case 4817:
			game = new String("City of Villains Test Server");
			break;
		case 4818:
			game = new String("Dreamfall");
			break;
		case 4819:
			game = new String("DawnOfMen");
			break;
		case 4820:
			game = new String("GameTap");
			break;
		case 4821:
			game = new String("Hitman Blood Money");
			break;
		case 4822:
			game = new String("Half-Life 2: Episode One");
			break;
		case 4823:
			game = new String("Black & White 2 Battle of the Gods");
			break;
		case 4824:
			game = new String("The Longest Journey");
			break;
		case 4825:
			game = new String("Shadowgrounds");
			break;
		case 4826:
			game = new String("The Da Vinci Code");
			break;
		case 4827:
			game = new String("Star Trek Armada II");
			break;
		case 4828:
			game = new String("Star Trek Away Team");
			break;
		case 4829:
			game = new String("Hidden: Source");
			break;
		case 4830:
			game = new String("Goldeneye: Source");
			break;
		case 4831:
			game = new String("Kreedz Climbing");
			break;
		case 4832:
			game = new String("Empires");
			break;
		case 4833:
			game = new String("Rogue Squadron");
			break;
		case 4834:
			game = new String("Star Wars Starfighter");
			break;
		case 4835:
			game = new String("Stacked");
			break;
		case 4836:
			game = new String("Asheron's Call");
			break;
		case 4837:
			game = new String("The Movies Stunts & Effects");
			break;
		case 4838:
			game = new String("SimCity 3000");
			break;
		case 4840:
			game = new String("Game Tycoon");
			break;
		case 4841:
			game = new String("Total Overdose");
			break;
		case 4842:
			game = new String("Rush For Berlin");
			break;
		case 4843:
			game = new String("Xpand Rally");
			break;
		case 4844:
			game = new String("Locomotion");
			break;
		case 4845:
			game = new String("Dungeon Lords");
			break;
		case 4846:
			game = new String("Trainz Railroad Simulator 2006");
			break;
		case 4847:
			game = new String("Freedom Fighters");
			break;
		case 4848:
			game = new String("Prey Demo");
			break;
		case 4849:
			game = new String("Onimusha 3");
			break;
		case 4850:
			game = new String("Warsow");
			break;
		case 4851:
			game = new String("Albatross18");
			break;
		case 4852:
			game = new String("Sprint Cars: Road to Knoxville");
			break;
		case 4853:
			game = new String("Hitman - Codename 47");
			break;
		case 4854:
			game = new String("The Suffering Ties That Bind");
			break;
		case 4855:
			game = new String("Rise & Fall");
			break;
		case 4856:
			game = new String("City Life");
			break;
		case 4857:
			game = new String("Rogue Trooper");
			break;
		case 4858:
			game = new String("Prey");
			break;
		case 4859:
			game = new String("NFL Head Coach");
			break;
		case 4860:
			game = new String("Act of War - High Treason");
			break;
		case 4861:
			game = new String("The Ship");
			break;
		case 4862:
			game = new String("X-Wing Alliance");
			break;
		case 4863:
			game = new String("Hero Online");
			break;
		case 4864:
			game = new String("Land of the Dead");
			break;
		case 4865:
			game = new String("Sword of the Stars Demo");
			break;
		case 4866:
			game = new String("Civilization IV - Warlords");
			break;
		case 4867:
			game = new String("CivCity Rome");
			break;
		case 4868:
			game = new String("OutRun2006 Coast 2 Coast");
			break;
		case 4869:
			game = new String("Glory of the Roman Empire");
			break;
		case 4870:
			game = new String("Sacrifice");
			break;
		case 4871:
			game = new String("MechWarrior 3");
			break;
		case 4872:
			game = new String("Dawn of War Dark Crusade");
			break;
		case 4873:
			game = new String("MechWarrior 4 Black Knight");
			break;
		case 4874:
			game = new String("Dungeon Siege II Broken World");
			break;
		case 4875:
			game = new String("Flatout 2");
			break;
		case 4876:
			game = new String("Untold Legends: Dark Kingdom");
			break;
		case 4877:
			game = new String("Hellgate: London");
			break;
		case 4878:
			game = new String("Company of Heroes Multiplayer Beta");
			break;
		case 4879:
			game = new String("FEAR Multiplayer");
			break;
		case 4880:
			game = new String("Battlefield 2142");
			break;
		case 4881:
			game = new String("Monopoly Tycoon");
			break;
		case 4882:
			game = new String("Madden NFL 07");
			break;
		case 4883:
			game = new String("Company of Heroes Single Player Demo");
			break;
		case 4884:
			game = new String("Dawn of War Dark Crusade Demo");
			break;
		case 5143:
			game = new String("Company of Heroes: Opposing Fronts");
			break;
		case 4885:
			game = new String("Company of Heroes");
			break;
		case 4886:
			game = new String("Lego Star Wars II");
			break;
		case 4887:
			game = new String("Mall Tycoon");
			break;
		case 4888:
			game = new String("Mall Tycoon 2");
			break;
		case 4889:
			game = new String("Mall Tycoon 3");
			break;
		case 4890:
			game = new String("School Tycoon");
			break;
		case 4891:
			game = new String("Airport Tycoon");
			break;
		case 4892:
			game = new String("Prison Tycoon 2");
			break;
		case 4893:
			game = new String("First Battalion");
			break;
		case 4894:
			game = new String("Faces of War");
			break;
		case 4895:
			game = new String("Patriots: A Nation Under Fire");
			break;
		case 4896:
			game = new String("Caesar 4 Demo");
			break;
		case 4897:
			game = new String("Dark Messiah Multiplayer Open Beta");
			break;
		case 4898:
			game = new String("FEAR Extraction Point SP Demo");
			break;
		case 4899:
			game = new String("Mage Knight Apocalypse");
			break;
		case 4900:
			game = new String("Caesar 4");
			break;
		case 4901:
			game = new String("NBA Live 07");
			break;
		case 4902:
			game = new String("NHL 07");
			break;
		case 4903:
			game = new String("Just Cause");
			break;
		case 4904:
			game = new String("The Sims 2 Glamour Life Stuff");
			break;
		case 4905:
			game = new String("FIFA 07");
			break;
		case 4906:
			game = new String("Disciples 2 - Gallean's Return");
			break;
		case 4907:
			game = new String("Disciples 2 - Rise of the Elves");
			break;
		case 4908:
			game = new String("Joint Task Force");
			break;
		case 4909:
			game = new String("Battlefield 2142 Demo");
			break;
		case 4910:
			game = new String("GTR 2");
			break;
		case 4911:
			game = new String("Scarface");
			break;
		case 4912:
			game = new String("Archlord");
			break;
		case 4913:
			game = new String("Medieval II Total War Demo SE");
			break;
		case 4914:
			game = new String("War Front - Turning Point");
			break;
		case 4915:
			game = new String("Gothic III");
			break;
		case 4916:
			game = new String("Tiger Woods PGA Tour 07");
			break;
		case 4917:
			game = new String("El Matador");
			break;
		case 4918:
			game = new String("Paraworld");
			break;
		case 4919:
			game = new String("Frets on Fire");
			break;
		case 4920:
			game = new String("Defcon");
			break;
		case 4921:
			game = new String("Championship Manager 2006");
			break;
		case 4922:
			game = new String("Age of Empires III: The WarChiefs");
			break;
		case 4923:
			game = new String("Microsoft Flight Simulator X");
			break;
		case 4924:
			game = new String("BZFlag");
			break;
		case 4925:
			game = new String("The Sims 2 Pets");
			break;
		case 4926:
			game = new String("Sid Meier's Railroads");
			break;
		case 4927:
			game = new String("The Guild 2");
			break;
		case 4928:
			game = new String("Neocron 2");
			break;
		case 4929:
			game = new String("Devil May Cry 3 Special Edition");
			break;
		case 4930:
			game = new String("Space Empires IV Deluxe");
			break;
		case 4931:
			game = new String("Space Empires V");
			break;
		case 4932:
			game = new String("Shot Online");
			break;
		case 4934:
			game = new String("Star Wars Empire at War Forces of Corruption");
			break;
		case 4935:
			game = new String("Phantasy Star Universe Online");
			break;
		case 4936:
			game = new String("Dark Messiah Multiplayer");
			break;
		case 4937:
			game = new String("Dark Messiah Single Player");
			break;
		case 4938:
			game = new String("FEAR Extraction Point");
			break;
		case 4939:
			game = new String("Stronghold Legends");
			break;
		case 4940:
			game = new String("Perimeter");
			break;
		case 4941:
			game = new String("Perimeter Emperor's Testament");
			break;
		case 4942:
			game = new String("Neverwinter Nights 2");
			break;
		case 4943:
			game = new String("Need for Speed Carbon");
			break;
		case 4944:
			game = new String("Marvel Ultimate Alliance");
			break;
		case 4945:
			game = new String("Need for Speed Carbon Demo");
			break;
		case 4946:
			game = new String("Pro Evolution Soccer 6");
			break;
		case 4947:
			game = new String("Football Manager 2007");
			break;
		case 4948:
			game = new String("Championship Manager 2007");
			break;
		case 4949:
			game = new String("Splinter Cell Double Agent Single Player");
			break;
		case 4950:
			game = new String("Splinter Cell Double Agent Multiplayer");
			break;
		case 4951:
			game = new String("SkillGround.com");
			break;
		case 4952:
			game = new String("1701 A.D.");
			break;
		case 4953:
			game = new String("Medieval II Total War");
			break;
		case 4954:
			game = new String("Panzer Command");
			break;
		case 4955:
			game = new String("Warhammer Mark of Chaos");
			break;
		case 4956:
			game = new String("Heroes of Might and Magic V - Hammers of Fate");
			break;
		case 4957:
			game = new String("Falcon 4.0 Allied Force");
			break;
		case 4958:
			game = new String("Eragon");
			break;
		case 4959:
			game = new String("The Settlers II - 10th Anniversary");
			break;
		case 4960:
			game = new String("Reservoir Dogs");
			break;
		case 4961:
			game = new String("Digital Paint: Paintball 2");
			break;
		case 4962:
			game = new String(
					"The Lord of the Rings, The Rise of the Witch-king");
			break;
		case 4963:
			game = new String("Rappelz Epic3");
			break;
		case 4964:
			game = new String("Star Trek Legacy");
			break;
		case 4965:
			game = new String("Tom Clancy's Rainbow Six Vegas");
			break;
		case 4966:
			game = new String("ijji GunZ");
			break;
		case 4967:
			game = new String("Vanguard - Saga of Heroes");
			break;
		case 4968:
			game = new String("CABAL Online (Europe)");
			break;
		case 4969:
			game = new String("Trickster Revolution");
			break;
		case 4970:
			game = new String("Pirates of the Caribbean");
			break;
		case 4971:
			game = new String("Dark Age of Camelot - Labyrinth of the Minotaur");
			break;
		case 4972:
			game = new String("Battlefield 1942 Multiplayer Demo");
			break;
		case 4973:
			game = new String("Battlefield 1942 Singleplayer Demo");
			break;
		case 4974:
			game = new String("Battlefield 1942 Secret Weapons of WWII Demo");
			break;
		case 4975:
			game = new String("Titan Quest Immortal Throne");
			break;
		case 4976:
			game = new String("Supreme Commander");
			break;
		case 4977:
			game = new String("Goonzu Online");
			break;
		case 4978:
			game = new String("25 to Life");
			break;
		case 4979:
			game = new String("Battlestations Midway");
			break;
		case 4980:
			game = new String("Bad Day LA");
			break;
		case 4981:
			game = new String("Let's Ride! - Silver Buckle Stables");
			break;
		case 4982:
			game = new String("James Bond 007 Nightfire");
			break;
		case 4983:
			game = new String("Mythos");
			break;
		case 4984:
			game = new String("Soldier Front");
			break;
		case 4985:
			game = new String("The Sims Life Stories");
			break;
		case 4986:
			game = new String("Maelstrom");
			break;
		case 4987:
			game = new String("The Curse of Monkey Island");
			break;
		case 4988:
			game = new String("Escape from Monkey Island");
			break;
		case 4989:
			game = new String("TMNT Demo");
			break;
		case 4990:
			game = new String("Warhammer Mark of Chaos MP Demo");
			break;
		case 4991:
			game = new String("Trackmania United Forever");
			break;
		case 4992:
			game = new String("Absolute Poker.com");
			break;
		case 4993:
			game = new String("Doyles Room.com");
			break;
		case 4994:
			game = new String("Everest Poker.com");
			break;
		case 4995:
			game = new String("Full Tilt Poker.com");
			break;
		case 4996:
			game = new String("Paradise Poker.com");
			break;
		case 4997:
			game = new String("PKR.com");
			break;
		case 4998:
			game = new String("Ultimate Bet.com");
			break;
		case 4999:
			game = new String("WPTOnline.com");
			break;
		case 5000:
			game = new String("Command & Conquer 3 Tiberium Wars Demo");
			break;
		case 5001:
			game = new String("Jade Empire");
			break;
		case 5002:
			game = new String("The Sims 2 Seasons");
			break;
		case 5003:
			game = new String("Space Rangers 2");
			break;
		case 5004:
			game = new String("Railroad Tycoon II");
			break;
		case 5005:
			game = new String("Railroad Tycoon II Platinum");
			break;
		case 5006:
			game = new String("Sonic Riders");
			break;
		case 5007:
			game = new String("Sonic Heroes");
			break;
		case 5008:
			game = new String("Source SDK Base");
			break;
		case 5009:
			game = new String("S.T.A.L.K.E.R. - Shadow of Chernobyl");
			break;
		case 5010:
			game = new String("TMNT");
			break;
		case 5011:
			game = new String("Silent Hunter Wolves of the Pacific");
			break;
		case 5012:
			game = new String("Silverfall");
			break;
		case 5013:
			game = new String("Command & Conquer 3 Tiberium Wars");
			break;
		case 5014:
			game = new String("Test Drive Unlimited");
			break;
		case 5015:
			game = new String("18 Wheels of Steel Haulin");
			break;
		case 5016:
			game = new String("rFactor");
			break;
		case 5017:
			game = new String("Half-Life Deathmatch: Source");
			break;
		case 5018:
			game = new String("Baseball Mogul 2008");
			break;
		case 5019:
			game = new String("Genesis Rising");
			break;
		case 5020:
			game = new String("Call of Juarez");
			break;
		case 5021:
			game = new String("The Lord of the Rings Online");
			break;
		case 5720:
			game = new String("The Sims 2 Double Deluxe");
			break;
		case 5022:
			game = new String("The Sims 2 Celebration! Stuff");
			break;
		case 5023:
			game = new String("ArmA");
			break;
		case 5024:
			game = new String("Tortuga - Two Treasures");
			break;
		case 5025:
			game = new String("Europa Universalis III");
			break;
		case 5026:
			game = new String("Winning Eleven Pro Evolution Soccer 2007");
			break;
		case 5027:
			game = new String("Race - The WTCC Game");
			break;
		case 5028:
			game = new String("Resident Evil 4");
			break;
		case 5029:
			game = new String("Ancient Wars - Sparta");
			break;
		case 5030:
			game = new String("Spider-Man 3");
			break;
		case 5031:
			game = new String("Frontline - Fields of Thunder");
			break;
		case 5032:
			game = new String("Broken Sword - The Angel of Death");
			break;
		case 5033:
			game = new String("Cricket 07");
			break;
		case 5034:
			game = new String("Chess Titans");
			break;
		case 5035:
			game = new String("Inkball");
			break;
		case 5036:
			game = new String("Mahjong Titans");
			break;
		case 5037:
			game = new String("Purble Place");
			break;
		case 5038:
			game = new String("Hold 'Em");
			break;
		case 5039:
			game = new String("Brian Lara International Cricket 2007");
			break;
		case 5040:
			game = new String("LMA Manager 2007");
			break;
		case 5041:
			game = new String("UEFA Champions League 2006-2007");
			break;
		case 5042:
			game = new String("FIFA Manager 07");
			break;
		case 5043:
			game = new String("Virtua Tennis 3");
			break;
		case 5044:
			game = new String("Boiling Point");
			break;
		case 5045:
			game = new String("Cellfactor Revolution");
			break;
		case 5046:
			game = new String("Infernal");
			break;
		case 5047:
			game = new String("Crazy Taxi");
			break;
		case 5048:
			game = new String("Last Chaos USA");
			break;
		case 5049:
			game = new String("The Sims 2 Deluxe");
			break;
		case 5050:
			game = new String("Harry Potter and the Prisoner of Azkaban");
			break;
		case 5051:
			game = new String("Broken Sword - The Sleeping Dragon");
			break;
		case 5052:
			game = new String("Syberia");
			break;
		case 5053:
			game = new String("Syberia2");
			break;
		case 5054:
			game = new String("Voyage Century Online");
			break;
		case 5055:
			game = new String("Sauerbraten");
			break;
		case 5056:
			game = new String("Dogz 4");
			break;
		case 5057:
			game = new String("Freeciv - beta");
			break;
		case 5058:
			game = new String("Tibia");
			break;
		case 5059:
			game = new String("UFO - Extraterrestrial");
			break;
		case 5060:
			game = new String("Pirates of the Caribbean - At World's End");
			break;
		case 5061:
			game = new String("Halo 2");
			break;
		case 5062:
			game = new String("Attack on Pearl Harbor");
			break;
		case 5063:
			game = new String("Red Alert: A Path Beyond");
			break;
		case 5064:
			game = new String("Entropia Universe");
			break;
		case 5065:
			game = new String("World of Padman");
			break;
		case 5066:
			game = new String("Populous - The Beginning");
			break;
		case 5067:
			game = new String("Populous - The Beginning - Undiscovered Worlds");
			break;
		case 5068:
			game = new String("Tomb Raider - Anniversary");
			break;
		case 5069:
			game = new String("Baldur's Gate II");
			break;
		case 5070:
			game = new String("Birth of America");
			break;
		case 5071:
			game = new String("Neverwinter Nights 2 AMD 64 Version");
			break;
		case 5073:
			game = new String("Harry Potter and the Sorcerer's Stone");
			break;
		case 5074:
			game = new String("Harry Potter - Quidditch World Cup");
			break;
		case 5075:
			game = new String("Sword of the Stars - Born of Blood");
			break;
		case 5076:
			game = new String("Audition");
			break;
		case 5077:
			game = new String("DiRT");
			break;
		case 5078:
			game = new String("Scions of fate");
			break;
		case 5079:
			game = new String("Tremulous");
			break;
		case 5080:
			game = new String("Enemy Territory: QUAKE Wars");
			break;
		case 5081:
			game = new String("Catz (Deprecated)");
			break;
		case 5082:
			game = new String("Dogz (Deprecated)");
			break;
		case 5083:
			game = new String("The Sims 2 H&M Fashion Stuff");
			break;
		case 5084:
			game = new String("The Sims Pet Stories");
			break;
		case 5085:
			game = new String("Overlord");
			break;
		case 5086:
			game = new String("Monster Madness - Battle for Suburbia");
			break;
		case 5087:
			game = new String("Lost Planet Extreme Condition");
			break;
		case 5088:
			game = new String("Harry Potter and the Order of the Phoenix");
			break;
		case 5089:
			game = new String("D.i.R.T. - Origin of the Species");
			break;
		case 5090:
			game = new String("Hospital Tycoon");
			break;
		case 5091:
			game = new String("Mount & Blade");
			break;
		case 5092:
			game = new String("World in Conflict - BETA");
			break;
		case 5093:
			game = new String("Mysteries of the Sith");
			break;
		case 5094:
			game = new String("Sword of the New World");
			break;
		case 5095:
			game = new String("Transformers - The Game");
			break;
		case 5096:
			game = new String("Insurgency - Modern Infantry Combat");
			break;
		case 5097:
			game = new String("Ghost Recon Advanced Warfighter 2");
			break;
		case 5098:
			game = new String("Kwonho");
			break;
		case 5099:
			game = new String("Penumbra Overture Ep1");
			break;
		case 5100:
			game = new String("Taito Legends 2");
			break;
		case 5101:
			game = new String("Dungeon Runners");
			break;
		case 5102:
			game = new String("3D Model Trains");
			break;
		case 5103:
			game = new String("Civilization IV - Beyond the Sword");
			break;
		case 5104:
			game = new String("Baseball Mogul 2007");
			break;
		case 5105:
			game = new String("MicroMachines V4");
			break;
		case 5106:
			game = new String("Catz");
			break;
		case 5107:
			game = new String("Dogz");
			break;
		case 5108:
			game = new String("Rappelz Epic5");
			break;
		case 5109:
			game = new String("Metin 2");
			break;
		case 5110:
			game = new String("Tabula Rasa");
			break;
		case 5111:
			game = new String("Warhammer Online Beta");
			break;
		case 5112:
			game = new String("Avencast");
			break;
		case 5113:
			game = new String("2Moons");
			break;
		case 5114:
			game = new String("DANCE! Online");
			break;
		case 5115:
			game = new String("Madden NFL 08");
			break;
		case 5116:
			game = new String("Shadowrun");
			break;
		case 5117:
			game = new String("FreeStyle Street Basketball");
			break;
		case 5118:
			game = new String("BioShock Demo");
			break;
		case 5119:
			game = new String("BioShock");
			break;
		case 5120:
			game = new String("Medal of Honor: Airborne");
			break;
		case 5121:
			game = new String("Medal of Honor: Airborne - Demo");
			break;
		case 5122:
			game = new String("World in Conflict - DEMO");
			break;
		case 5123:
			game = new String("Two Worlds Demo");
			break;
		case 5124:
			game = new String("Two Worlds");
			break;
		case 5125:
			game = new String("Medieval II Total War: Kingdoms");
			break;
		case 5126:
			game = new String("Tiger Woods PGA Tour 08");
			break;
		case 5127:
			game = new String("Desperate Housewives");
			break;
		case 5128:
			game = new String("Urban Terror");
			break;
		case 5129:
			game = new String("Pet Vet 3D Animal Hospital");
			break;
		case 5130:
			game = new String("The Sims 2 Bon Voyage");
			break;
		case 5131:
			game = new String("Enemy Territory: QUAKE Wars Demo");
			break;
		case 5132:
			game = new String("World in Conflict Single Player");
			break;
		case 5133:
			game = new String("World in Conflict Multiplayer");
			break;
		case 5134:
			game = new String("Team Fortress 2");
			break;
		case 5135:
			game = new String("Peggle Extreme");
			break;
		case 5136:
			game = new String("Mayhem Intergalactic");
			break;
		case 5137:
			game = new String("Mayhem Intergalactic Demo");
			break;
		case 5138:
			game = new String("Crysis MP Beta");
			break;
		case 5139:
			game = new String("Frontlines: Fuel of War Beta");
			break;
		case 5140:
			game = new String("Drift City");
			break;
		case 5141:
			game = new String("John Woo Presents Stranglehold");
			break;
		case 5142:
			game = new String("NHL 08");
			break;
		case 5144:
			game = new String("Blazing Angels 2: Secret Missions of WWII");
			break;
		case 5145:
			game = new String("Big Mutha Truckers 2");
			break;
		case 5146:
			game = new String("Fortress Forever");
			break;
		case 5147:
			game = new String("The Settlers: Rise of an Empire");
			break;
		case 5148:
			game = new String("Babo Violent 2");
			break;
		case 5149:
			game = new String("CodeNameD: BlueShift");
			break;
		case 5150:
			game = new String("KartRider");
			break;
		case 5151:
			game = new String("CSI: Hard Evidence");
			break;
		case 5152:
			game = new String("UFO: Afterlight");
			break;
		case 5153:
			game = new String("Portal");
			break;
		case 5154:
			game = new String("Half-Life 2: Episode Two");
			break;
		case 5155:
			game = new String("FIFA 08");
			break;
		case 5156:
			game = new String("Loki");
			break;
		case 5157:
			game = new String("Call of Duty 4: Modern Warfare Demo");
			break;
		case 5158:
			game = new String("Unreal Tournament 3 Demo");
			break;
		case 5159:
			game = new String("Project Torque");
			break;
		case 5160:
			game = new String("Sid Meier's SimGolf");
			break;
		case 5161:
			game = new String("Legends");
			break;
		case 5162:
			game = new String("Brain Spa");
			break;
		case 5163:
			game = new String("Heroes of Might and Magic V: Tribes of the East");
			break;
		case 5164:
			game = new String("Fury");
			break;
		case 5165:
			game = new String("Hellgate: London Demo");
			break;
		case 5166:
			game = new String("City Life Deluxe");
			break;
		case 5167:
			game = new String("Galactic Civilizations II: Dark Avatar");
			break;
		case 5168:
			game = new String("CSPromod Beta");
			break;
		case 5169:
			game = new String("8BallClub");
			break;
		case 5170:
			game = new String("Worldwide Soccer Manager 2008");
			break;
		case 5171:
			game = new String("Football Manager 2008");
			break;
		case 5172:
			game = new String("Clive Barker's Jericho");
			break;
		case 5173:
			game = new String("Age of Empires III: The Asian Dynasties");
			break;
		case 5174:
			game = new String("Dynasty Warriors 4 Hyper");
			break;
		case 5175:
			game = new String("Crysis SP Demo");
			break;
		case 5176:
			game = new String("Painkiller: Overdose");
			break;
		case 5177:
			game = new String("SunAge");
			break;
		case 5178:
			game = new String("Luminary: Rise of Goonzu");
			break;
		case 5179:
			game = new String("The Witcher");
			break;
		case 5180:
			game = new String("TimeShift");
			break;
		case 5181:
			game = new String("Happy Feet");
			break;
		case 5182:
			game = new String("NBA Live 08");
			break;
		case 5183:
			game = new String("Taito Legends");
			break;
		case 5184:
			game = new String("Perfect World");
			break;
		case 5185:
			game = new String("Call of Duty 4: Modern Warfare Single Player");
			break;
		case 5186:
			game = new String("Call of Duty 4: Modern Warfare Multiplayer");
			break;
		case 5187:
			game = new String("Supreme Commander: Forged Alliance");
			break;
		case 5188:
			game = new String("Empire Earth III");
			break;
		case 5189:
			game = new String("FEAR Perseus Mandate");
			break;
		case 5190:
			game = new String("Gears of War");
			break;
		case 5191:
			game = new String("Dawn of War: Soulstorm");
			break;
		case 5192:
			game = new String("Pro Evolution Soccer 2008");
			break;
		case 5193:
			game = new String("Chessmaster Grandmaster Edition");
			break;
		case 5194:
			game = new String("Crysis");
			break;
		case 5195:
			game = new String("Dawn of Magic");
			break;
		case 5196:
			game = new String("You Are Empty");
			break;
		case 5197:
			game = new String("Guitar Hero III");
			break;
		case 5198:
			game = new String("Need for Speed ProStreet");
			break;
		case 5199:
			game = new String("Beowulf");
			break;
		case 5873:
			game = new String("Simcity Societies Destinations");
			break;
		case 5200:
			game = new String("Simcity Societies");
			break;
		case 5201:
			game = new String("Pinball Wizards: Balls of Steel Demo");
			break;
		case 5202:
			game = new String("Spider-Man: Friend or Foe");
			break;
		case 5203:
			game = new String("BlackSite: Area 51");
			break;
		case 5204:
			game = new String("Soldier of Fortune: Payback");
			break;
		case 5205:
			game = new String("Viva Pinata");
			break;
		case 5206:
			game = new String("WolfTeam International");
			break;
		case 5207:
			game = new String("Fantasy Wars");
			break;
		case 5208:
			game = new String("Unreal Tournament 3");
			break;
		case 5209:
			game = new String("Avencast: Rise of The Mage");
			break;
		case 5210:
			game = new String("Next Life");
			break;
		case 5211:
			game = new String("Risk");
			break;
		case 5212:
			game = new String("Instinct");
			break;
		case 5213:
			game = new String("Gothic");
			break;
		case 5214:
			game = new String("Kane and Lynch: Dead Men");
			break;
		case 5215:
			game = new String("Exteel");
			break;
		case 5216:
			game = new String("The Office");
			break;
		case 5217:
			game = new String("Escape From Paradise City");
			break;
		case 5218:
			game = new String("Catz 2");
			break;
		case 5219:
			game = new String("Dogz 2");
			break;
		case 5220:
			game = new String("Horsez 2");
			break;
		case 5221:
			game = new String("BMW M3 Challenge");
			break;
		case 5222:
			game = new String("Dofus");
			break;
		case 5223:
			game = new String("Quake");
			break;
		case 5224:
			game = new String("SEGA Rally Revo");
			break;
		case 5225:
			game = new String("Planeshift");
			break;
		case 5226:
			game = new String("Alpha Prime");
			break;
		case 5227:
			game = new String("Ghost in the Sheet");
			break;
		case 5228:
			game = new String("Ascension");
			break;
		case 5229:
			game = new String("Speedball 2 - Tournament");
			break;
		case 5230:
			game = new String("Alvin and the Chipmunks");
			break;
		case 5231:
			game = new String("Fiesta");
			break;
		case 5232:
			game = new String("Universe At War: Earth Assault");
			break;
		case 5233:
			game = new String("RACE 07");
			break;
		case 5234:
			game = new String("Battle for the Pacific");
			break;
		case 5235:
			game = new String("Warmonger - Operation: Downtown Destruction");
			break;
		case 5236:
			game = new String("Arcanum: Of Steamworks and Magick Obscura");
			break;
		case 5237:
			game = new String("Shogun: Total War");
			break;
		case 5238:
			game = new String("Shaiya");
			break;
		case 5239:
			game = new String("The Golden Compass");
			break;
		case 5240:
			game = new String("Dream Of Mirror Online");
			break;
		case 5241:
			game = new String("PKRCasino");
			break;
		case 5242:
			game = new String("Twelve Sky");
			break;
		case 5243:
			game = new String("Regnum Online");
			break;
		case 5244:
			game = new String("Beyond Divinity");
			break;
		case 5245:
			game = new String("Geometry Wars: Retro Evolved");
			break;
		case 5246:
			game = new String("Kane and Lynch: Dead Men Demo");
			break;
		case 5247:
			game = new String("Hard To Be a God Demo");
			break;
		case 5248:
			game = new String("Indiana Jones and the Emperors Tomb");
			break;
		case 5249:
			game = new String("Grand Theft Auto");
			break;
		case 5250:
			game = new String("Peggle Deluxe");
			break;
		case 5251:
			game = new String("Juiced 2: Hot Import Nights");
			break;
		case 5252:
			game = new String(
					"Phantasy Star Universe: Ambition of the Illuminus");
			break;
		case 5253:
			game = new String("Pirates of the Burning Sea");
			break;
		case 5254:
			game = new String("Battlestar Galactica");
			break;
		case 5255:
			game = new String("Puzzle Quest: Challenge of the Warlords");
			break;
		case 5256:
			game = new String("Dawn of War: Soulstorm Demo");
			break;
		case 5257:
			game = new String("Teeworlds");
			break;
		case 5258:
			game = new String("Metal Gear Solid");
			break;
		case 5259:
			game = new String("Indiana Jones and the Infernal Machine");
			break;
		case 5260:
			game = new String("Divine Divinity");
			break;
		case 5261:
			game = new String("Rising Eagle");
			break;
		case 5262:
			game = new String("Hard Truck: 18 Wheels of Steel");
			break;
		case 5263:
			game = new String("Stranded II");
			break;
		case 5264:
			game = new String("Pirates of the Caribbean Online");
			break;
		case 5265:
			game = new String("Wild Metal Country");
			break;
		case 5266:
			game = new String("GGPO.net");
			break;
		case 5267:
			game = new String("Jewel Quest");
			break;
		case 5268:
			game = new String("9Dragons");
			break;
		case 5269:
			game = new String("Feeding Frenzy 2 Deluxe");
			break;
		case 5270:
			game = new String("Bejeweled Deluxe");
			break;
		case 5271:
			game = new String("Bejeweled 2 Deluxe");
			break;
		case 5272:
			game = new String("Chuzzle Deluxe");
			break;
		case 5273:
			game = new String("Insaniquarium Deluxe");
			break;
		case 5274:
			game = new String("AstroPop Deluxe");
			break;
		case 5275:
			game = new String("Iggle Pop Deluxe");
			break;
		case 5276:
			game = new String("Zuma Deluxe");
			break;
		case 5277:
			game = new String("Dynomite Deluxe");
			break;
		case 5278:
			game = new String("Big Money Deluxe");
			break;
		case 5279:
			game = new String("Heavy Weapon Deluxe");
			break;
		case 5280:
			game = new String("Pizza Frenzy Deluxe");
			break;
		case 5281:
			game = new String("Hammer Heads Deluxe");
			break;
		case 5282:
			game = new String("Typer Shark Deluxe");
			break;
		case 5283:
			game = new String("Rail Simulator");
			break;
		case 5284:
			game = new String("Bookworm Deluxe");
			break;
		case 5285:
			game = new String("Bookworm Adventures Deluxe");
			break;
		case 5726:
			game = new String("Sins of a Solar Empire: Entrenchment");
			break;
		case 5286:
			game = new String("Sins of a Solar Empire");
			break;
		case 5287:
			game = new String("The Sims Castaway Stories");
			break;
		case 5288:
			game = new String("Thrillville: Off the Rails");
			break;
		case 5289:
			game = new String("Secret of the Solstice");
			break;
		case 5290:
			game = new String("CABAL Online: The Revolution of Action");
			break;
		case 5291:
			game = new String("Holic");
			break;
		case 5292:
			game = new String("Racer Beta");
			break;
		case 5293:
			game = new String("FIFA Manager 08");
			break;
		case 5294:
			game = new String("The Spiderwick Chronicles");
			break;
		case 5295:
			game = new String("Conflict: Denied Ops");
			break;
		case 5296:
			game = new String("Harley-Davidson Race to the Rally");
			break;
		case 5297:
			game = new String("Manga Fighter");
			break;
		case 5298:
			game = new String("Audiosurf");
			break;
		case 5299:
			game = new String("Impossible Creatures");
			break;
		case 5300:
			game = new String("Resident Evil 3: Nemesis");
			break;
		case 5301:
			game = new String("Theme Hospital");
			break;
		case 5302:
			game = new String("AirRivals");
			break;
		case 5303:
			game = new String("RuneScape");
			break;
		case 5304:
			game = new String("Penumbra: Black Plague");
			break;
		case 5305:
			game = new String("Hello Kitty Cutie World");
			break;
		case 5306:
			game = new String("Beyond Good & Evil");
			break;
		case 5307:
			game = new String("The Club");
			break;
		case 5308:
			game = new String("Europa 1400: The Guild (Gold)");
			break;
		case 5309:
			game = new String("Red Stone");
			break;
		case 5310:
			game = new String("Frontlines: Fuel of War");
			break;
		case 5311:
			game = new String("Grand Chase (Asia)");
			break;
		case 5312:
			game = new String("Grand Chase");
			break;
		case 5313:
			game = new String("The Sims 2 FreeTime");
			break;
		case 5314:
			game = new String("Turning Point: Fall of Liberty");
			break;
		case 5315:
			game = new String("Lost: Via Domus");
			break;
		case 5316:
			game = new String("Phun");
			break;
		case 5317:
			game = new String("SpaceForce Captains");
			break;
		case 5318:
			game = new String("NASCAR Racing 2002 Season");
			break;
		case 5319:
			game = new String("Darkeden");
			break;
		case 5320:
			game = new String("The Experiment");
			break;
		case 5321:
			game = new String("FairyLand");
			break;
		case 5322:
			game = new String("Fritz 8");
			break;
		case 5323:
			game = new String("Bots");
			break;
		case 5324:
			game = new String("Crusaders: Thy Kingdom Come");
			break;
		case 5325:
			game = new String("Crusaders: Thy Kingdom Come Multiplayer");
			break;
		case 5326:
			game = new String("Cal Ripken's Real Baseball");
			break;
		case 5327:
			game = new String("Pirates, Vikings and Knights II");
			break;
		case 5328:
			game = new String("Worms 2");
			break;
		case 5329:
			game = new String("Savage 2: A Tortured Soul");
			break;
		case 5330:
			game = new String("Phantasy Star Online: Blue Burst");
			break;
		case 5331:
			game = new String("Pirateville");
			break;
		case 5332:
			game = new String("Upshift StrikeRacer");
			break;
		case 5333:
			game = new String("Glest");
			break;
		case 5334:
			game = new String("WorldShift Beta");
			break;
		case 5335:
			game = new String("Seven Kingdoms: Conquest");
			break;
		case 5336:
			game = new String("Powerboat GT");
			break;
		case 5337:
			game = new String("Chessmaster 10th Edition");
			break;
		case 5338:
			game = new String("Red Baron Arcade");
			break;
		case 5339:
			game = new String("The Shield");
			break;
		case 5340:
			game = new String("Mind Quiz");
			break;
		case 5341:
			game = new String("Ricochet Infinity");
			break;
		case 5342:
			game = new String("Command & Conquer 3: Kane's Wrath");
			break;
		case 5343:
			game = new String("Lost Empire: Immortals");
			break;
		case 5344:
			game = new String("Hard Truck 2");
			break;
		case 5345:
			game = new String("Lights Out");
			break;
		case 5346:
			game = new String("SWAT 3");
			break;
		case 5347:
			game = new String("The Sims Carnival: BumperBlast");
			break;
		case 5348:
			game = new String("The Sims Carnival: SnapCity");
			break;
		case 5349:
			game = new String("Toribash");
			break;
		case 5350:
			game = new String("Osu!");
			break;
		case 5351:
			game = new String("Pet Luv Spa and Resort Tycoon");
			break;
		case 5352:
			game = new String("Perfect Dark: Source");
			break;
		case 5353:
			game = new String("Trials 2: Second Edition");
			break;
		case 5354:
			game = new String("Synergy");
			break;
		case 5355:
			game = new String("Rohan: Blood Feud");
			break;
		case 5356:
			game = new String("Warriors Orochi");
			break;
		case 5357:
			game = new String("Alien Arena 2008");
			break;
		case 5358:
			game = new String("Ninja Reflex: Steamworks Edition");
			break;
		case 5359:
			game = new String("Lunia");
			break;
		case 5360:
			game = new String("Uplink");
			break;
		case 5361:
			game = new String("Slayers Online");
			break;
		case 5362:
			game = new String("Second Sight");
			break;
		case 5363:
			game = new String("Imperium Romanum");
			break;
		case 5364:
			game = new String("Yu-Gi-Oh! Online: Duel Evolution");
			break;
		case 5365:
			game = new String("Assassin's Creed");
			break;
		case 5366:
			game = new String("Terra: Battle for the Outlands");
			break;
		case 5367:
			game = new String("Darkstar One");
			break;
		case 5368:
			game = new String("OpenTTD");
			break;
		case 5369:
			game = new String("NosTale EU");
			break;
		case 5370:
			game = new String("Jagged Alliance 2 Gold");
			break;
		case 5371:
			game = new String("American McGee's Alice");
			break;
		case 5372:
			game = new String("Skulltag");
			break;
		case 5373:
			game = new String("Saga");
			break;
		case 5374:
			game = new String("Trackmania Nations Forever");
			break;
		case 5375:
			game = new String("Tom Clancy's Rainbow Six Vegas 2");
			break;
		case 5376:
			game = new String("The Sims 2 Kitchen & Bath Interior Design Stuff");
			break;
		case 5377:
			game = new String("Kung Fu Panda Demo");
			break;
		case 5378:
			game = new String("Melty Blood: Act Cadenza");
			break;
		case 5379:
			game = new String("Seal Online USA");
			break;
		case 5380:
			game = new String("Magic Online III");
			break;
		case 5381:
			game = new String("Ultimate Doom");
			break;
		case 5382:
			game = new String("Master Levels of Doom");
			break;
		case 5383:
			game = new String("Final Doom");
			break;
		case 5384:
			game = new String("Doom 2");
			break;
		case 5385:
			game = new String("Cabela's Dangerous Hunts 2");
			break;
		case 5386:
			game = new String("Turok");
			break;
		case 5387:
			game = new String("Clive Barker's Undying");
			break;
		case 5388:
			game = new String("Lumines");
			break;
		case 5389:
			game = new String("Europa Universalis: Rome");
			break;
		case 5390:
			game = new String("Planescape: Torment");
			break;
		case 5391:
			game = new String("Dirty Dancing: The Video Game");
			break;
		case 5392:
			game = new String("Age of Conan: Hyborian Adventures");
			break;
		case 5393:
			game = new String("The House of the Dead 3");
			break;
		case 5394:
			game = new String("The House of the Dead 2");
			break;
		case 5395:
			game = new String("Iron Man");
			break;
		case 5396:
			game = new String("Sherlock Holmes: Nemesis");
			break;
		case 5397:
			game = new String(
					"Galactic Civilizations II: Twilight of the Arnor");
			break;
		case 5398:
			game = new String("Imperialism II");
			break;
		case 5399:
			game = new String("Star Wars: Battle for Naboo");
			break;
		case 5400:
			game = new String("Grand Prix 4");
			break;
		case 5401:
			game = new String("Tomb Raider II");
			break;
		case 5402:
			game = new String("Commandos 3: Destination Berlin");
			break;
		case 5403:
			game = new String("Capitalism II");
			break;
		case 5404:
			game = new String("Tales of Pirates Online");
			break;
		case 5405:
			game = new String("Bet and Race");
			break;
		case 5406:
			game = new String("Commandos: Behind Enemy Lines");
			break;
		case 5407:
			game = new String("Magic The Gathering: Battlegrounds");
			break;
		case 5408:
			game = new String("Everyday Shooter");
			break;
		case 5409:
			game = new String("Graal Online");
			break;
		case 5410:
			game = new String("Heretic II");
			break;
		case 5411:
			game = new String("Conflict: Global Terror");
			break;
		case 5412:
			game = new String("Jack Keane");
			break;
		case 5413:
			game = new String("Shogo: Mobile Armor Division");
			break;
		case 5414:
			game = new String("Cossacks: The Art Of War");
			break;
		case 5415:
			game = new String("Requiem: Bloodymare");
			break;
		case 5416:
			game = new String("Hello Kitty Online");
			break;
		case 5417:
			game = new String(
					"On the Rain-Slick Precipice of Darkness, Episode One");
			break;
		case 5418:
			game = new String("PseudoQuest");
			break;
		case 5419:
			game = new String(
					"Mortimer Beckett and the Secrets of Spooky Manor");
			break;
		case 5420:
			game = new String("Silent Hunter II");
			break;
		case 5421:
			game = new String("Flanker 2.5");
			break;
		case 5422:
			game = new String("The Continuum");
			break;
		case 5423:
			game = new String("Great War Nations: The Spartans");
			break;
		case 5424:
			game = new String("Shadowgrounds Survivor");
			break;
		case 5425:
			game = new String("Mass Effect");
			break;
		case 5426:
			game = new String("Lost Planet: Extreme Condition Colonies Edition");
			break;
		case 5427:
			game = new String("G-Police");
			break;
		case 5428:
			game = new String("Heroes of Might and Magic III Complete");
			break;
		case 5429:
			game = new String("GRID Demo");
			break;
		case 5430:
			game = new String("Icewind Dale II");
			break;
		case 5431:
			game = new String("Day of Defeat: Source Beta");
			break;
		case 5432:
			game = new String("Spaceinvasion");
			break;
		case 5433:
			game = new String("ChaosCars");
			break;
		case 5434:
			game = new String("Gladiators II");
			break;
		case 5435:
			game = new String("Seafight");
			break;
		case 5436:
			game = new String("DarkOrbit");
			break;
		case 5437:
			game = new String("Lego Indiana Jones: The Original Adventures");
			break;
		case 5438:
			game = new String("GRID");
			break;
		case 5440:
			game = new String("Guilty Gear x2 Reload");
			break;
		case 5441:
			game = new String("Nitro Stunt Race Stage 1");
			break;
		case 5442:
			game = new String("MTV's Virtual World");
			break;
		case 5443:
			game = new String("Kung Fu Panda");
			break;
		case 5444:
			game = new String("Aliens versus Predator Gold Edition");
			break;
		case 5445:
			game = new String("Turok 2: Seeds of Evil Singleplayer");
			break;
		case 5446:
			game = new String("Turok 2: Seeds of Evil Multiplayer");
			break;
		case 5447:
			game = new String("Wonderland Online");
			break;
		case 5448:
			game = new String("Devil May Cry 4 Trial");
			break;
		case 5449:
			game = new String("Blokus World Tour");
			break;
		case 5450:
			game = new String("Star Sonata");
			break;
		case 5451:
			game = new String("Bullet Candy");
			break;
		case 5452:
			game = new String("Bus Driver");
			break;
		case 5453:
			game = new String("The Incredible Hulk");
			break;
		case 5454:
			game = new String("Stronghold Crusader Extreme");
			break;
		case 5455:
			game = new String("Marble Blast Gold");
			break;
		case 5456:
			game = new String("UEFA Euro 2008");
			break;
		case 5458:
			game = new String("Little Farm");
			break;
		case 5459:
			game = new String("SPORE Creature Creator");
			break;
		case 5460:
			game = new String("Psi-Ops: The Mindgate Conspiracy");
			break;
		case 5461:
			game = new String("Zu Online");
			break;
		case 5462:
			game = new String("Angels Online");
			break;
		case 5463:
			game = new String("Dreamlords: The Reawakening");
			break;
		case 5464:
			game = new String("Alien Shooter");
			break;
		case 5465:
			game = new String("WALL-E");
			break;
		case 5466:
			game = new String("Alone In The Dark");
			break;
		case 5467:
			game = new String("Crazy Machines 2");
			break;
		case 5468:
			game = new String("Out of the Park Baseball 9");
			break;
		case 5469:
			game = new String("The Sims 2 IKEA Home Stuff");
			break;
		case 5470:
			game = new String("World of Kung Fu");
			break;
		case 5471:
			game = new String("Making History: The Calm and The Storm");
			break;
		case 5472:
			game = new String("Freelanc3r");
			break;
		case 5473:
			game = new String("Genleo: The Land of Eratica");
			break;
		case 5474:
			game = new String("Seeds of Time Online");
			break;
		case 5475:
			game = new String("Oil Imperium");
			break;
		case 5476:
			game = new String("Combat Arms");
			break;
		case 5477:
			game = new String("Cardmaster Conflict");
			break;
		case 5478:
			game = new String("Freedom Force");
			break;
		case 5479:
			game = new String("Ultimate Pimpin'");
			break;
		case 5480:
			game = new String("Safari Photo Africa: Wild Earth");
			break;
		case 5481:
			game = new String("Supreme Ruler 2020");
			break;
		case 5482:
			game = new String("The Political Machine 2008");
			break;
		case 5483:
			game = new String("CS-Manager");
			break;
		case 5484:
			game = new String("Devil May Cry 4");
			break;
		case 5485:
			game = new String("Immune Attack");
			break;
		case 5486:
			game = new String("Carmageddon II: Carpocalypse Now!");
			break;
		case 5487:
			game = new String("Panzer Elite");
			break;
		case 5488:
			game = new String("Dark Colony");
			break;
		case 5489:
			game = new String("Enclave");
			break;
		case 5490:
			game = new String("Carmageddon TDR2000");
			break;
		case 5491:
			game = new String("Rayman Raving Rabbids");
			break;
		case 5492:
			game = new String("Rigs of Rods");
			break;
		case 5493:
			game = new String("7 Wonders of the Ancient World");
			break;
		case 5494:
			game = new String("Eternal Lands");
			break;
		case 5495:
			game = new String("The Golden Horde");
			break;
		case 5496:
			game = new String("Roogoo");
			break;
		case 5497:
			game = new String("Bomberman Online");
			break;
		case 5498:
			game = new String("Elements");
			break;
		case 5499:
			game = new String("The Wonderful End of the World");
			break;
		case 5500:
			game = new String("Halo Trial");
			break;
		case 5501:
			game = new String("Space Chimps");
			break;
		case 5502:
			game = new String("7 Wonders II");
			break;
		case 5503:
			game = new String("Sacred Gold");
			break;
		case 5504:
			game = new String("UniBall");
			break;
		case 5505:
			game = new String("Warrior Epic");
			break;
		case 5506:
			game = new String("World of Warcraft: Wrath of the Lich King Beta");
			break;
		case 5507:
			game = new String("Jutland Beta");
			break;
		case 5508:
			game = new String("IGI-2: Covert Strike");
			break;
		case 5509:
			game = new String("CQC: Close Quarter Combat");
			break;
		case 5510:
			game = new String("Q-World");
			break;
		case 5511:
			game = new String("Majesty Gold Edition");
			break;
		case 5512:
			game = new String("Majesty Gold Edition: The Northern Expansion");
			break;
		case 5513:
			game = new String("I.G.I.: I'm Going In");
			break;
		case 5514:
			game = new String("Transport Giant");
			break;
		case 5515:
			game = new String("Command & Conquer: Red Alert 3 Beta");
			break;
		case 5516:
			game = new String("The Settlers III");
			break;
		case 5517:
			game = new String("Beijing 2008");
			break;
		case 5518:
			game = new String("Eschalon Book I");
			break;
		case 5519:
			game = new String("Sudden Strike 3: Arms for Victory");
			break;
		case 5520:
			game = new String("Project Powder Beta");
			break;
		case 5521:
			game = new String("Xiah Rebirth");
			break;
		case 5522:
			game = new String("Asda Story");
			break;
		case 5523:
			game = new String("Dream Pinball 3D");
			break;
		case 5524:
			game = new String("Sho Online");
			break;
		case 5525:
			game = new String("Space Siege");
			break;
		case 5526:
			game = new String("Shattered Suns");
			break;
		case 5527:
			game = new String("Harino");
			break;
		case 5528:
			game = new String("Pro Cycling Manager Season 2008");
			break;
		case 5529:
			game = new String("QPang");
			break;
		case 5530:
			game = new String("FATE: Undiscovered Realms");
			break;
		case 5531:
			game = new String("Dracula: Origin");
			break;
		case 5532:
			game = new String("The Sims 2 Apartment Life");
			break;
		case 5533:
			game = new String("Hunting Unlimited 2009");
			break;
		case 5534:
			game = new String("FlatOut: Ultimate Carnage");
			break;
		case 5535:
			game = new String("Battlefield Heroes");
			break;
		case 5536:
			game = new String("4Story");
			break;
		case 5537:
			game = new String("Legend: Hand of God");
			break;
		case 5538:
			game = new String("Pi Story");
			break;
		case 5539:
			game = new String("Mercenaries 2: World in Flames");
			break;
		case 5540:
			game = new String("SPORE");
			break;
		case 5541:
			game = new String("Dracula 3: The Path of the Dragon");
			break;
		case 5542:
			game = new String("Demigod");
			break;
		case 5543:
			game = new String("Rome: Total War: Alexander");
			break;
		case 5544:
			game = new String("Arca Sim Racing");
			break;
		case 5545:
			game = new String("Oddworld: Abe's Exoddus");
			break;
		case 5546:
			game = new String("Oddworld: Abe's Oddysee");
			break;
		case 5547:
			game = new String("FIFA 09 Demo");
			break;
		case 5548:
			game = new String("S.T.A.L.K.E.R.: Clear Sky");
			break;
		case 5549:
			game = new String("Warhammer Online: Age of Reckoning");
			break;
		case 5550:
			game = new String("Crysis Warhead");
			break;
		case 5551:
			game = new String("Crysis Wars");
			break;
		case 5552:
			game = new String("Romance of the Three Kingdoms XI");
			break;
		case 5553:
			game = new String("Pure");
			break;
		case 5554:
			game = new String("Source SDK Base: Orange Box");
			break;
		case 5555:
			game = new String("Lego Batman");
			break;
		case 5556:
			game = new String(
					"Strong Bad's Cool Game for Attractive People Episode 1: Homestar Ruiner");
			break;
		case 5557:
			game = new String(
					"Strong Bad's Cool Game for Attractive People Episode 2: Strong Badia the Free");
			break;
		case 5558:
			game = new String("Civilization IV: Colonization");
			break;
		case 5559:
			game = new String("Perfect World International");
			break;
		case 5560:
			game = new String("Multiwinia");
			break;
		case 5561:
			game = new String("City Life 2008");
			break;
		case 5562:
			game = new String("King's Bounty: The Legend");
			break;
		case 5563:
			game = new String("1701 A.D.: The Sunken Dragon");
			break;
		case 5564:
			game = new String("The Suffering");
			break;
		case 5565:
			game = new String("Russia's Army");
			break;
		case 5566:
			game = new String("Atlantica Online");
			break;
		case 5567:
			game = new String("Men of War Beta");
			break;
		case 5568:
			game = new String("Ultima Online: Kingdom Reborn");
			break;
		case 5569:
			game = new String("Pro Evolution Soccer 2009 Demo");
			break;
		case 5570:
			game = new String("Sacred 2 - Fallen Angel");
			break;
		case 5571:
			game = new String("Brothers In Arms: Hell's Highway");
			break;
		case 5572:
			game = new String("Hinterland");
			break;
		case 5573:
			game = new String("Age of Chivalry");
			break;
		case 5574:
			game = new String("Zombie Panic! Source");
			break;
		case 5575:
			game = new String("D.I.P.R.I.P. Warm Up");
			break;
		case 5576:
			game = new String("Shocking Void");
			break;
		case 5577:
			game = new String("HighStreet 5");
			break;
		case 5578:
			game = new String("FIFA Soccer 09");
			break;
		case 5579:
			game = new String("World of Goo");
			break;
		case 5580:
			game = new String("Line Rider 2");
			break;
		case 5581:
			game = new String("The Guild 2 Venice");
			break;
		case 5582:
			game = new String("Nostradamus - The Last Prophecy");
			break;
		case 5583:
			game = new String("NHL 09");
			break;
		case 5584:
			game = new String("Dead Space");
			break;
		case 5585:
			game = new String("Guitar Hero: Aerosmith");
			break;
		case 5586:
			game = new String("Baseball Mogul 2009");
			break;
		case 5587:
			game = new String("Dark Horizon");
			break;
		case 5588:
			game = new String("S4 League");
			break;
		case 5589:
			game = new String("Miniconomy");
			break;
		case 5590:
			game = new String("Far Cry 2");
			break;
		case 5592:
			game = new String("Spectraball");
			break;
		case 5593:
			game = new String("NBA 2K9");
			break;
		case 5594:
			game = new String("Bully: Scholarship Edition");
			break;
		case 5595:
			game = new String("X3: Terran Conflict");
			break;
		case 5596:
			game = new String("Exodus From The Earth (Single player game)");
			break;
		case 5597:
			game = new String("Exodus From The Earth (Network game)");
			break;
		case 5598:
			game = new String("Space Trader");
			break;
		case 5599:
			game = new String("Fallout 3");
			break;
		case 5600:
			game = new String("Call of Duty: World at War Beta Multiplayer");
			break;
		case 5601:
			game = new String("Command & Conquer: Red Alert 3");
			break;
		case 5602:
			game = new String("MotoGP 08");
			break;
		case 5603:
			game = new String("Euro Truck Simulator");
			break;
		case 5604:
			game = new String("My Sims");
			break;
		case 5605:
			game = new String("Interstate '76");
			break;
		case 5606:
			game = new String("Football Manager 2009 Demo");
			break;
		case 5607:
			game = new String("Spider-Man: Web of Shadows");
			break;
		case 5608:
			game = new String("Combat Wings: Battle of Britain");
			break;
		case 5609:
			game = new String("Cesar Millan's Dog Whisperer");
			break;
		case 5610:
			game = new String("Endless Online");
			break;
		case 5611:
			game = new String("OceanWar");
			break;
		case 5612:
			game = new String("Quantum of Solace");
			break;
		case 5830:
			game = new String("GCP PES 2009");
			break;
		case 5613:
			game = new String("Pro Evolution Soccer 2009");
			break;
		case 5614:
			game = new String(
					"On the Rain-Slick Precipice of Darkness, Episode Two");
			break;
		case 5615:
			game = new String("Left 4 Dead Demo");
			break;
		case 5616:
			game = new String("Legacy of Kain: Defiance");
			break;
		case 5617:
			game = new String("Legacy of Kain: Soul Reaver");
			break;
		case 5618:
			game = new String("Silent Hill Homecoming");
			break;
		case 5619:
			game = new String("Avatar: Path of Zuko");
			break;
		case 5620:
			game = new String("Galactic Bowling");
			break;
		case 5621:
			game = new String("Sniper- Art of Victory");
			break;
		case 5622:
			game = new String("Deer Hunter Tournament");
			break;
		case 5623:
			game = new String("Call of Duty: World at War Singleplayer");
			break;
		case 5624:
			game = new String("Call of Duty: World at War Multiplayer");
			break;
		case 5625:
			game = new String("Deadliest Catch Alaskan Storm");
			break;
		case 5626:
			game = new String("Everlight of Magic & Power");
			break;
		case 5627:
			game = new String("Rhiannon: Curse of the Four Branches");
			break;
		case 5628:
			game = new String("Hell's Kitchen");
			break;
		case 5629:
			game = new String("Grand Prix Legends");
			break;
		case 5630:
			game = new String("Tomb Raider: Underworld Demo");
			break;
		case 5631:
			game = new String("Rumble Fighter");
			break;
		case 5632:
			game = new String("Avatar: Legends of the Arena");
			break;
		case 5633:
			game = new String("Left 4 Dead");
			break;
		case 5634:
			game = new String("Worldwide Soccer Manager 2009");
			break;
		case 5635:
			game = new String("Need for Speed Undercover");
			break;
		case 5636:
			game = new String("The Sims 2: Mansion and Garden Stuff");
			break;
		case 5637:
			game = new String("Tomb Raider: Underworld");
			break;
		case 5638:
			game = new String("Madagascar: Escape 2 Africa");
			break;
		case 5639:
			game = new String("Lords of Evil");
			break;
		case 5640:
			game = new String("Street Gears");
			break;
		case 5641:
			game = new String("Dynasty Warriors 6");
			break;
		case 5642:
			game = new String("FIFA Manager 09");
			break;
		case 5643:
			game = new String("Pokemon World Online");
			break;
		case 5644:
			game = new String("Eets");
			break;
		case 5645:
			game = new String("Bodog Poker");
			break;
		case 5646:
			game = new String("Mr. Robot");
			break;
		case 5647:
			game = new String("AssaultCube");
			break;
		case 5648:
			game = new String("Pyroblazer");
			break;
		case 5649:
			game = new String("Mosby's Confederacy");
			break;
		case 5650:
			game = new String("Eudemons Online");
			break;
		case 5651:
			game = new String("Gothic III - Forsaken Gods");
			break;
		case 5652:
			game = new String("Cross Fire");
			break;
		case 5653:
			game = new String("Football Manager 2009");
			break;
		case 5654:
			game = new String("Grand Theft Auto IV");
			break;
		case 5655:
			game = new String("Shin Megami Tensei Imagine Online");
			break;
		case 5656:
			game = new String("Shaun White Snowboarding");
			break;
		case 5657:
			game = new String("Legendary");
			break;
		case 5658:
			game = new String("Zero Online");
			break;
		case 5659:
			game = new String("I-Fluid");
			break;
		case 5660:
			game = new String("Desperados: Wanted Dead or Alive");
			break;
		case 5661:
			game = new String("Defense Grid: The Awakening");
			break;
		case 5662:
			game = new String("Jazz Jackrabbit 2");
			break;
		case 5663:
			game = new String("Prince of Persia");
			break;
		case 5664:
			game = new String("A Vampyre Story");
			break;
		case 5665:
			game = new String("Secret Service: In Harm's Way");
			break;
		case 5666:
			game = new String("Runes of Magic");
			break;
		case 5667:
			game = new String("Iron Grip Warlord");
			break;
		case 5668:
			game = new String("Florensia");
			break;
		case 5669:
			game = new String("Rise of the Argonauts");
			break;
		case 5671:
			game = new String("CSI: NY");
			break;
		case 5672:
			game = new String("Depths of Peril");
			break;
		case 5673:
			game = new String("BattleForge Beta");
			break;
		case 5674:
			game = new String("Legacy");
			break;
		case 5675:
			game = new String("Shaiya DE");
			break;
		case 5676:
			game = new String("Mach 1 Demo");
			break;
		case 5677:
			game = new String("Saints Row 2");
			break;
		case 5678:
			game = new String("MashON SPORE Comic Book Creator");
			break;
		case 5679:
			game = new String("Operation 7");
			break;
		case 5680:
			game = new String("SecondEarth: Faction Wars");
			break;
		case 5681:
			game = new String("Secondearth MMO");
			break;
		case 5682:
			game = new String("Mirror's Edge");
			break;
		case 5683:
			game = new String("The Lord of the Rings: Conquest");
			break;
		case 5684:
			game = new String("La Tale");
			break;
		case 5685:
			game = new String("The Chronicles of Spellborn");
			break;
		case 5686:
			game = new String("Wizard 101");
			break;
		case 5687:
			game = new String("Warhammer 40,000: Dawn of War II - Beta");
			break;
		case 5688:
			game = new String("F.E.A.R. 2: Project Origin SP Demo");
			break;
		case 5689:
			game = new String("Aquaria");
			break;
		case 5690:
			game = new String("EDuke32");
			break;
		case 5691:
			game = new String("PangYa");
			break;
		case 5692:
			game = new String("18 Wheels of Steel American Long Haul");
			break;
		case 5693:
			game = new String("MLB Front Office Manager");
			break;
		case 5694:
			game = new String(
					"Commander In Chief - Geopolitical Simulator 2009");
			break;
		case 5695:
			game = new String("Tantra Global");
			break;
		case 5696:
			game = new String("Colin McRae Rally 3");
			break;
		case 5697:
			game = new String("Nexuiz");
			break;
		case 5698:
			game = new String("Colin McRae Rally 2");
			break;
		case 5699:
			game = new String("Jewel Quest 2");
			break;
		case 5700:
			game = new String("Jewel Quest Solitaire");
			break;
		case 5701:
			game = new String("Jewel Quest Solitaire 2");
			break;
		case 5702:
			game = new String("Bejeweled Twist");
			break;
		case 5703:
			game = new String("Kega Fusion");
			break;
		case 5704:
			game = new String("Burnout Paradise: The Ultimate Box");
			break;
		case 5705:
			game = new String("Galactic Civilizations II: Ultimate Edition");
			break;
		case 5706:
			game = new String("X-Blades");
			break;
		case 5707:
			game = new String("Everonia");
			break;
		case 5708:
			game = new String("F.E.A.R. 2: Project Origin");
			break;
		case 5709:
			game = new String("Perimeter 2: New Earth");
			break;
		case 5710:
			game = new String("Neopets Puzzle Adventure");
			break;
		case 5711:
			game = new String("Poker For Dummies");
			break;
		case 5712:
			game = new String("Operation Mania");
			break;
		case 5713:
			game = new String("Ace Online");
			break;
		case 5714:
			game = new String("Littlest Pet Shop");
			break;
		case 5715:
			game = new String("Multi Theft Auto: San Andreas");
			break;
		case 5716:
			game = new String("Project of Planets");
			break;
		case 5717:
			game = new String("Talisman Online");
			break;
		case 5718:
			game = new String("Roblox");
			break;
		case 5719:
			game = new String("Warhammer 40,000: Dawn of War II");
			break;
		case 5721:
			game = new String("Drakensang: The Dark Eye");
			break;
		case 5722:
			game = new String("ShellShock 2: Blood of Trails");
			break;
		case 5723:
			game = new String("Tom Clancy's EndWar");
			break;
		case 5724:
			game = new String("Puzzle Quest: Galactrix");
			break;
		case 5725:
			game = new String("Driver: Parallel Lines");
			break;
		case 5727:
			game = new String("Empire: Total War Demo");
			break;
		case 5728:
			game = new String("Tom Clancy's H.A.W.X Demo");
			break;
		case 5729:
			game = new String("The Last Remnant Demo");
			break;
		case 5730:
			game = new String("Empire: Total War");
			break;
		case 5732:
			game = new String("Football Manager Live");
			break;
		case 5733:
			game = new String("Watchmen: The End Is Nigh");
			break;
		case 5734:
			game = new String("ijji Splash Fighters");
			break;
		case 5735:
			game = new String("Global Agenda Beta");
			break;
		case 5736:
			game = new String("Major League Baseball 2K9");
			break;
		case 5737:
			game = new String("Command & Conquer Red Alert 3: Uprising");
			break;
		case 5738:
			game = new String("Darkfall");
			break;
		case 5739:
			game = new String("Age of Booty");
			break;
		case 5740:
			game = new String("Codename: Panzers - Cold War");
			break;
		case 5741:
			game = new String("Grey's Anatomy");
			break;
		case 5742:
			game = new String("Three Kingdoms");
			break;
		case 5743:
			game = new String("The Story of Legends");
			break;
		case 5799:
			game = new String("Men of War Multiplayer");
			break;
		case 5744:
			game = new String("Men of War");
			break;
		case 5745:
			game = new String("Tom Clancy's H.A.W.X. (DX10)");
			break;
		case 5746:
			game = new String("Tom Clancy's H.A.W.X. (DX9)");
			break;
		case 5747:
			game = new String("Ceville");
			break;
		case 5748:
			game = new String("Priston Tale 2");
			break;
		case 5749:
			game = new String("Magica Online");
			break;
		case 5750:
			game = new String("Wanted: Weapons of Fate");
			break;
		case 5751:
			game = new String("BattleForge");
			break;
		case 5752:
			game = new String("The Last Remnant");
			break;
		case 5753:
			game = new String("Wheelman");
			break;
		case 5754:
			game = new String("Stormrise");
			break;
		case 5755:
			game = new String("Fantasy Tennis 2");
			break;
		case 5756:
			game = new String("Theatre of War");
			break;
		case 5757:
			game = new String("Atmosphir Beta");
			break;
		case 5758:
			game = new String("The Maw");
			break;
		case 5759:
			game = new String("Dark Sector");
			break;
		case 5760:
			game = new String(
					"Wallace and Gromit Ep1: Fright of the Bumblebees");
			break;
		case 5761:
			game = new String("Grand Ages Rome");
			break;
		case 5762:
			game = new String("Trainz Simulator 2009: World Builder Edition");
			break;
		case 5763:
			game = new String(
					"The Chronicles of Riddick: Assault on Dark Athena");
			break;
		case 5764:
			game = new String("Leisure Suit Larry: Box Office Bust");
			break;
		case 5765:
			game = new String("Monsters vs. Aliens");
			break;
		case 5766:
			game = new String("The Godfather II");
			break;
		case 5767:
			game = new String("Penumbra: Requiem");
			break;
		case 5768:
			game = new String("FLOCK!");
			break;
		case 5769:
			game = new String("Braid");
			break;
		case 5770:
			game = new String("Artifact");
			break;
		case 5771:
			game = new String("Quake Live");
			break;
		case 6015:
			game = new String("Elven Legacy: Siege");
			break;
		case 5772:
			game = new String("Elven Legacy");
			break;
		case 5773:
			game = new String("And Yet It Moves");
			break;
		case 5774:
			game = new String("DCS: Black Shark");
			break;
		case 5775:
			game = new String("Hard To Be a God");
			break;
		case 5776:
			game = new String("Fistful of Frags");
			break;
		case 5777:
			game = new String("Zeno Clash");
			break;
		case 5778:
			game = new String("Free Realms");
			break;
		case 5779:
			game = new String("X-Com Enforcer");
			break;
		case 5780:
			game = new String("X-Com Interceptor");
			break;
		case 5781:
			game = new String("Aion");
			break;
		case 5782:
			game = new String("Battle Realms");
			break;
		case 5783:
			game = new String("Scarygirl");
			break;
		case 5784:
			game = new String("Cryostasis");
			break;
		case 5785:
			game = new String("Age of Wonders II: The Wizard's Throne");
			break;
		case 5786:
			game = new String("Velvet Assassin");
			break;
		case 5787:
			game = new String("Stalin vs. Martians");
			break;
		case 5788:
			game = new String("SnowBound Online");
			break;
		case 5789:
			game = new String("X-Men Origins: Wolverine");
			break;
		case 5790:
			game = new String("Dofus Arena");
			break;
		case 5791:
			game = new String("Dragon Fable");
			break;
		case 5792:
			game = new String("Plants Vs Zombies");
			break;
		case 5793:
			game = new String("Ogame");
			break;
		case 5794:
			game = new String("Football Superstars");
			break;
		case 5795:
			game = new String("Puzzle Kingdoms");
			break;
		case 5796:
			game = new String("Adventure Quest");
			break;
		case 5797:
			game = new String("NecroVision");
			break;
		case 5798:
			game = new String("MechQuest");
			break;
		case 5800:
			game = new String("Dragonica");
			break;
		case 5801:
			game = new String("ArchKnight");
			break;
		case 5802:
			game = new String("Ikariam.org");
			break;
		case 5803:
			game = new String("Battlestations Pacific");
			break;
		case 5804:
			game = new String("Killing Floor");
			break;
		case 5805:
			game = new String("Duels");
			break;
		case 5806:
			game = new String("Travian");
			break;
		case 5807:
			game = new String("Crayon Physics Deluxe");
			break;
		case 5808:
			game = new String("Ikariam.com");
			break;
		case 5809:
			game = new String("Muniz Online");
			break;
		case 5810:
			game = new String("RockFREE");
			break;
		case 5811:
			game = new String("Taikodom");
			break;
		case 5812:
			game = new String("Terminator Salvation");
			break;
		case 5813:
			game = new String("Legends of Zork");
			break;
		case 5814:
			game = new String("Gaia Online");
			break;
		case 5815:
			game = new String("Gladius II");
			break;
		case 5816:
			game = new String("The Pimps");
			break;
		case 5817:
			game = new String("Desktop Tower Defense");
			break;
		case 5818:
			game = new String("Bebees");
			break;
		case 5819:
			game = new String("Mafia 1930");
			break;
		case 5820:
			game = new String("Tunnel Rats 1968");
			break;
		case 5821:
			game = new String("UP");
			break;
		case 5822:
			game = new String("Damnation");
			break;
		case 5823:
			game = new String("Helldorado");
			break;
		case 5824:
			game = new String("Death Track: Resurrection");
			break;
		case 5825:
			game = new String("I Wanna Be the Guy");
			break;
		case 5826:
			game = new String("Neo Steam");
			break;
		case 5827:
			game = new String("Yosumin");
			break;
		case 5828:
			game = new String("The Sims 3");
			break;
		case 5829:
			game = new String("Rappelz Epic6");
			break;
		case 5831:
			game = new String("After-Death");
			break;
		case 5832:
			game = new String("Ether Saga Online");
			break;
		case 5833:
			game = new String("Twelve Sky 2");
			break;
		case 5834:
			game = new String("Dragonsky");
			break;
		case 5835:
			game = new String("Officers");
			break;
		case 5836:
			game = new String("Ys Online");
			break;
		case 5837:
			game = new String("Damoria");
			break;
		case 5838:
			game = new String("Prototype");
			break;
		case 5839:
			game = new String("Age of Pirates 2");
			break;
		case 5840:
			game = new String("Mo Siang Online (Singapore)");
			break;
		case 5841:
			game = new String("Luna Online (Singapore)");
			break;
		case 5842:
			game = new String("Spongebob");
			break;
		case 5843:
			game = new String("Ghostbusters");
			break;
		case 5844:
			game = new String("America's Army 3");
			break;
		case 5845:
			game = new String("MLB Dugout Heroes");
			break;
		case 5846:
			game = new String("Kicks Online");
			break;
		case 5847:
			game = new String("Jade Dynasty");
			break;
		case 5848:
			game = new String("Super Orbulite World");
			break;
		case 5849:
			game = new String("New Grounds");
			break;
		case 5850:
			game = new String("Kongregate");
			break;
		case 5851:
			game = new String("SPORE Galactic Adventures");
			break;
		case 5852:
			game = new String("Delta Force: Xtreme 2");
			break;
		case 5853:
			game = new String("Transformers: Revenge of the Fallen");
			break;
		case 5854:
			game = new String("Overlord II");
			break;
		case 5855:
			game = new String("Unsigned");
			break;
		case 5856:
			game = new String("ARMA 2");
			break;
		case 5857:
			game = new String("Astro Empires");
			break;
		case 5858:
			game = new String("Call of Juarez: Bound in Blood");
			break;
		case 5859:
			game = new String("Ice Age: Dawn of the Dinosaurs");
			break;
		case 5860:
			game = new String("Harry Potter and the Half-Blood Prince");
			break;
		case 5861:
			game = new String("Sudden Attack");
			break;
		case 5862:
			game = new String("ARMA 2 Demo");
			break;
		case 5863:
			game = new String("WolfTeam");
			break;
		case 5864:
			game = new String("Anno 1404: Dawn of Discovery");
			break;
		case 5865:
			game = new String("Street Fighter IV");
			break;
		case 5866:
			game = new String("Wordtrotter");
			break;
		case 5867:
			game = new String("Trine");
			break;
		case 5868:
			game = new String("Smashball");
			break;
		case 5869:
			game = new String("Virtua Tennis 2009");
			break;
		case 5870:
			game = new String("AddictingGames.com");
			break;
		case 5871:
			game = new String("Dragonica EU");
			break;
		case 5872:
			game = new String("Evony");
			break;
		case 5874:
			game = new String("Galactic Arms Race");
			break;
		case 5875:
			game = new String("Blood Bowl");
			break;
		case 5876:
			game = new String("Fuel");
			break;
		case 5877:
			game = new String("Droplitz");
			break;
		case 5878:
			game = new String("Pro Cycling Manager Season 2009");
			break;
		case 5879:
			game = new String("The Secret of Monkey Island");
			break;
		case 5880:
			game = new String("Tribal Wars");
			break;
		case 5881:
			game = new String("Luna Online");
			break;
		case 5882:
			game = new String("Guitar Hero World Tour");
			break;
		case 5883:
			game = new String("FunOrb");
			break;
		case 5884:
			game = new String("Section 8 Beta");
			break;
		case 5885:
			game = new String("InstantAction.com");
			break;
		case 5886:
			game = new String("Wrestling MPire 2008 (Career Edition)");
			break;
		case 5887:
			game = new String("Miniclip.com");
			break;
		case 5888:
			game = new String("Mini Fighter");
			break;
		case 5889:
			game = new String("Bejeweled 2");
			break;
		case 5890:
			game = new String("NeoTokyo");
			break;
		case 5891:
			game = new String("JamLegend");
			break;
		case 5892:
			game = new String("Bionic Commando Rearmed");
			break;
		case 5893:
			game = new String("Bionic Commando");
			break;
		case 5894:
			game = new String("Allegiance");
			break;
		case 5895:
			game = new String("Monato Esprit");
			break;
		case 5896:
			game = new String("Watchmen: The End Is Nigh Part 2");
			break;
		case 5897:
			game = new String("Bookworm Adventures Volume 2");
			break;
		case 5898:
			game = new String("The Battle for Wesnoth");
			break;
		case 6040:
			game = new String("East India Company: Battle of Trafalgar");
			break;
		case 5990:
			game = new String("East India Company: Privateer");
			break;
		case 5899:
			game = new String("East India Company");
			break;
		case 5900:
			game = new String("Sudeki");
			break;
		case 5901:
			game = new String("StarTopia");
			break;
		case 5902:
			game = new String("Doukutsu Monogatari");
			break;
		case 5903:
			game = new String("Alien Arena 2009");
			break;
		case 5904:
			game = new String("Foreign Legion: Buckets of Blood");
			break;
		case 5905:
			game = new String("Hearts of Iron III");
			break;
		case 5906:
			game = new String("Nikopol: Secrets of the Immortals");
			break;
		case 5907:
			game = new String("Huxley The Dystopia");
			break;
		case 5908:
			game = new String("Zuma");
			break;
		case 5909:
			game = new String("Peggle World of Warcraft Edition");
			break;
		case 5910:
			game = new String("Heroes of Newerth");
			break;
		case 5911:
			game = new String("Smash Online");
			break;
		case 5912:
			game = new String("Freespace 2");
			break;
		case 5913:
			game = new String("Wolfenstein Single Player");
			break;
		case 5914:
			game = new String("Wolfenstein Multiplayer");
			break;
		case 5915:
			game = new String("Champions Online");
			break;
		case 5916:
			game = new String("Joint Operations: Combined Arms Gold");
			break;
		case 5917:
			game = new String("Still Life 2");
			break;
		case 5918:
			game = new String("The Sims 2 University Life Collection");
			break;
		case 5919:
			game = new String("AI War");
			break;
		case 5920:
			game = new String("CrimeCraft");
			break;
		case 5921:
			game = new String("Divinity II: Ego Draconis");
			break;
		case 5922:
			game = new String("Runaway Gift");
			break;
		case 5923:
			game = new String("Raven Squad");
			break;
		case 5924:
			game = new String("Tales Runner");
			break;
		case 5925:
			game = new String("The Path");
			break;
		case 5926:
			game = new String("XIII Century Gold Edition");
			break;
		case 5927:
			game = new String("Section 8");
			break;
		case 5928:
			game = new String("Mini Ninjas");
			break;
		case 5929:
			game = new String("Berserk-Online");
			break;
		case 5930:
			game = new String("ARENA Online");
			break;
		case 5931:
			game = new String(" A Reckless Disregard for Gravity");
			break;
		case 5932:
			game = new String("Camorra World");
			break;
		case 5933:
			game = new String("Batman: Arkham Asylum");
			break;
		case 5934:
			game = new String("Need for Speed SHIFT");
			break;
		case 5935:
			game = new String("Red Faction: Guerrilla");
			break;
		case 5936:
			game = new String("Darkest of Days");
			break;
		case 5937:
			game = new String("Majesty 2: The Fantasy Kingdom Sim");
			break;
		case 5938:
			game = new String("Resident Evil 5");
			break;
		case 5939:
			game = new String("Krazy Aces");
			break;
		case 5940:
			game = new String("Fallen Earth");
			break;
		case 5941:
			game = new String("Dungeon Fighter Online");
			break;
		case 5942:
			game = new String("Alliance of Valiant Arms");
			break;
		case 5943:
			game = new String("Dekaron");
			break;
		case 5944:
			game = new String("K.O.S. Secret Operations");
			break;
		case 5945:
			game = new String("Ran Online");
			break;
		case 5946:
			game = new String("League of Legends");
			break;
		case 5947:
			game = new String("Operation Flashpoint: Dragon Rising");
			break;
		case 5948:
			game = new String("Order of War");
			break;
		case 5949:
			game = new String("Evochron Legends");
			break;
		case 5950:
			game = new String("Risen");
			break;
		case 5951:
			game = new String("Star Wars The Clone Wars: Republic Heroes");
			break;
		case 5952:
			game = new String("FIFA 10");
			break;
		case 5953:
			game = new String("Dragon Oath");
			break;
		case 5954:
			game = new String("Soul of the Ultimate Nation");
			break;
		case 5955:
			game = new String("Cities XL");
			break;
		case 5956:
			game = new String("Madballs in... Babo:Invasion");
			break;
		case 5957:
			game = new String("Heroes Over Europe");
			break;
		case 5958:
			game = new String("NBA 2K10");
			break;
		case 5959:
			game = new String("Prison Tycoon 3: Lockdown");
			break;
		case 5960:
			game = new String("Return to Mysterious Island 2");
			break;
		case 5961:
			game = new String("FATE - The Traitor Soul");
			break;
		case 5962:
			game = new String("NosTale");
			break;
		case 5963:
			game = new String("Tiny Tanks Online");
			break;
		case 5964:
			game = new String("Red War: Edem's Curse");
			break;
		case 5965:
			game = new String("Tropico 3");
			break;
		case 5966:
			game = new String("Celtic Kings");
			break;
		case 5967:
			game = new String("Parabellum");
			break;
		case 5968:
			game = new String("Pro Evolution Soccer 2010 Demo");
			break;
		case 5969:
			game = new String("Lucidity");
			break;
		case 5970:
			game = new String("Pro Evolution Soccer 2010");
			break;
		case 5971:
			game = new String("Borderlands");
			break;
		case 5972:
			game = new String("World of Zoo");
			break;
		case 5973:
			game = new String("Heroes of Gaia");
			break;
		case 5974:
			game = new String("FarmVille");
			break;
		case 5975:
			game = new String("Left 4 Dead 2 Demo");
			break;
		case 5976:
			game = new String("Torchlight");
			break;
		case 5977:
			game = new String("CSI: Deadly Intent");
			break;
		case 5978:
			game = new String("Saw");
			break;
		case 5979:
			game = new String("MDK");
			break;
		case 5980:
			game = new String("MDK 2");
			break;
		case 5981:
			game = new String("Football Manager 2010");
			break;
		case 5982:
			game = new String("4 Elements");
			break;
		case 5983:
			game = new String("FIFA Manager 10");
			break;
		case 5984:
			game = new String("Painkiller: Resurrection");
			break;
		case 5985:
			game = new String("Dragon Age: Origins");
			break;
		case 5986:
			game = new String("Dragon Age Journeys");
			break;
		case 5987:
			game = new String("Star Wars: The Force Unleashed");
			break;
		case 5988:
			game = new String("Around the World in 80 Days");
			break;
		case 5989:
			game = new String("Shattered Horizon");
			break;
		case 5991:
			game = new String("LEGO Star Wars: The Complete Saga");
			break;
		case 5992:
			game = new String("Call of Duty: Modern Warfare 2 Singleplayer");
			break;
		case 5993:
			game = new String("Call of Duty: Modern Warfare 2 Multiplayer");
			break;
		case 5994:
			game = new String("Jagged Alliance 2 Wildfire");
			break;
		case 5995:
			game = new String("Championship Manager 2010");
			break;
		case 5996:
			game = new String("Cricket Revolution");
			break;
		case 5997:
			game = new String("Haegemonia");
			break;
		case 5998:
			game = new String("Manhunt 2");
			break;
		case 5999:
			game = new String("Mercenary Wars");
			break;
		case 6000:
			game = new String("Bright Shadow");
			break;
		case 6001:
			game = new String("Dreamkiller");
			break;
		case 6002:
			game = new String("Fishdom");
			break;
		case 6003:
			game = new String("Left 4 Dead 2");
			break;
		case 6004:
			game = new String("The Sims 3: World Adventures");
			break;
		case 6005:
			game = new String("Lego Indiana Jones 2: The Adventure Continues");
			break;
		case 6006:
			game = new String("The Princess and the Frog");
			break;
		case 6007:
			game = new String("18 Wheels of Steel Extreme Trucker");
			break;
		case 6008:
			game = new String("Gyromancer");
			break;
		case 6009:
			game = new String("Star Trek: D-A-C");
			break;
		case 6010:
			game = new String("Allods Online");
			break;
		case 6011:
			game = new String("911: First Responders");
			break;
		case 6012:
			game = new String("Machinarium");
			break;
		case 6013:
			game = new String("King's Bounty: Armored Princess");
			break;
		case 6014:
			game = new String("The Chosen");
			break;
		case 6016:
			game = new String("Mafia Wars");
			break;
		case 6017:
			game = new String("Happy Aquarium");
			break;
		case 6018:
			game = new String("Serious Sam HD: The First Encounter");
			break;
		case 6019:
			game = new String("Rogue Warrior");
			break;
		case 6020:
			game = new String("WorldShift");
			break;
		case 6021:
			game = new String("James Cameron's AVATAR");
			break;
		case 6022:
			game = new String("Tomb Raider: The Angel Of Darkness");
			break;
		case 6023:
			game = new String("Osmos");
			break;
		case 6024:
			game = new String("SpellForce2 - Dragon Storm");
			break;
		case 6025:
			game = new String("Blood Bowl: Dark Elves Edition");
			break;
		case 6026:
			game = new String("King Arthur - The Role-playing Wargame");
			break;
		case 6027:
			game = new String("Hunting Unlimited 2008");
			break;
		case 6028:
			game = new String("Earthworm Jim 3D");
			break;
		case 6029:
			game = new String("Grand Fantasia");
			break;
		case 6030:
			game = new String("Twin Sector");
			break;
		case 6031:
			game = new String("The Saboteur");
			break;
		case 6032:
			game = new String("DiRT2");
			break;
		case 6033:
			game = new String("The Three Musketeers");
			break;
		case 6034:
			game = new String("Zombie Driver");
			break;
		case 6035:
			game = new String("Swashbucklers");
			break;
		case 6036:
			game = new String("A.I.M. 2 Clan Wars");
			break;
		case 6037:
			game = new String("War and Peace, 1796-1815");
			break;
		case 6038:
			game = new String("The Warlords");
			break;
		case 6039:
			game = new String("Elven Legacy: Magic");
			break;
		case 6041:
			game = new String("Nodiatis");
			break;
		case 6042:
			game = new String("Samoroft 2");
			break;
		case 6043:
			game = new String("CakeMania 3");
			break;
		case 6044:
			game = new String("eJay Techno 5");
			break;
		case 6045:
			game = new String("Horse Racing Manager");
			break;
		case 6046:
			game = new String("Wings Over Europe: Cold War Gone Hot");
			break;
		case 6047:
			game = new String("Wonder King");
			break;

		default:
			System.out.println("NO SUCH GAME IN THE LIST!");
		}

		
	   return game;
	}

    public static String byteArrayToHexString(byte in[], int length)

	{

		byte ch = 0x00;
		int i = 0;

		if (in == null || length <= 0)
			return null;

		String pseudo[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f" };

		StringBuffer out = new StringBuffer(length * 2);

		while (i < length) {
			ch = (byte) (in[i] & 0xF0); // Strip of high nibble
			ch = (byte) (ch >>> 4); // shift the bits down
			ch = (byte) (ch & 0x0F); // must do this is high order bit is on!
			out.append(pseudo[(int) ch]); // convert thenibble to a String
											// Character
			ch = (byte) (in[i] & 0x0F); // Strip offlow nib ble
			out.append(pseudo[(int) ch]); // convert the nibble to a String
											// Character
			i++;
		}
		String rslt = new String(out);
		return rslt;
	}
    
    
    public static void  SwitchUI(Activity activity,Class<?> cls)
    {
    	
    	Intent i = new Intent(activity, cls);
    	activity.startActivity(i);
    	
    }
   
    
    
    
    public static void openURL(Activity activity,String url)
    
    {
    
    	Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(url));
    	activity.startActivity(viewIntent);
    	
    	
    }
	
}