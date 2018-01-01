package com.company.Spell;

import com.company.Character.PlayerCharacter;

public interface IBuff {

    int getStatsRate();
    int getDuration();
    Effect.Effects_Type getEffect_type();
    Effect.Target_Type getTarget_type();
    void afterEffect(PlayerCharacter target);
    void effect(PlayerCharacter target);
}
