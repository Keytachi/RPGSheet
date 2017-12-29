package com.company.Spell;

import com.company.Character.PlayerCharacter;

public interface IBuff {

    int getDuration();
    Effect.Effects_Type getEffect_type();
    void effect(PlayerCharacter host);


}
