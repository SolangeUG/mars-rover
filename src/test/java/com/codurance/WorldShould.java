package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WorldShould {
    @Test
    public void return_true_on_IsInsideYouXUpperLimit() {
        World world = new World(2,2);
        assertThat(world.IsInsideYourXUpperLimit(2)).isTrue();
    }

    @Test
    public void return_false_on_IsInsideYouXUpperLimit() {
        World world = new World(2,2);
        assertThat(world.IsInsideYourXUpperLimit(3)).isFalse();
    }

    @Test
    public void return_true_on_IsInsideYouYUpperLimit() {
        World world = new World(2,2);
        assertThat(world.IsInsideYourYUpperLimit(2)).isTrue();
    }

    @Test
    public void return_false_on_IsInsideYouYUpperLimit() {
        World world = new World(2,2);
        assertThat(world.IsInsideYourYUpperLimit(3)).isFalse();
    }
    @Test
    public void return_true_on_IsInsideYouXLowerLimit() {
        World world = new World(2,2);
        assertThat(world.IsInsideYourXLowerLimit(1)).isTrue();
    }

    @Test
    public void return_false_on_IsInsideYouXLowerLimit() {
        World world = new World(2,2);
        assertThat(world.IsInsideYourXLowerLimit(0)).isFalse();
    }

    @Test
    public void return_true_on_IsInsideYouYLowerLimit() {
        World world = new World(2,2);
        assertThat(world.IsInsideYourYLowerLimit(1)).isTrue();
    }

    @Test
    public void return_false_on_IsInsideYouYLowerLimit() {
        World world = new World(2,2);
        assertThat(world.IsInsideYourYLowerLimit(0)).isFalse();
    }
}
