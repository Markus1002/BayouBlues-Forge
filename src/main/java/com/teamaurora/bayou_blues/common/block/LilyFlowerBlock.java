package com.teamaurora.bayou_blues.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsFlowerBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LilyFlowerBlock extends AbnormalsFlowerBlock {
    protected static final VoxelShape LILY_PAD_AABB = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);
    protected static final VoxelShape LILY_FLOWER_AABB = Block.makeCuboidShape(3.0D, 1.5D, 3.0D, 13.0D, 13.D, 13.0D);
    protected static final VoxelShape SHAPE = VoxelShapes.or(LILY_PAD_AABB, LILY_FLOWER_AABB);
    private final Supplier<Item> item;

    public static List<LilyFlowerBlock> LILY_FLOWERS = new ArrayList<>();

    public LilyFlowerBlock(Supplier<Item> item, Properties builder) {
        super(()->Effects.POISON, 12, builder);
        this.item = item;
        LILY_FLOWERS.add(this);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return LILY_PAD_AABB;
    }

    @Override
    @SuppressWarnings("deprecation")
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(this.item.get());
    }

    public static Block getRandomLily(Random rand) {
        return LILY_FLOWERS.get(rand.nextInt(LILY_FLOWERS.size()));
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        FluidState fluidstate = worldIn.getFluidState(pos.down());
        FluidState fluidstate1 = worldIn.getFluidState(pos);
        return (fluidstate.getFluid() == Fluids.WATER || state.getMaterial() == Material.ICE) && fluidstate1.getFluid() == Fluids.EMPTY;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityCollision(state, worldIn, pos, entityIn);
        if (worldIn instanceof ServerWorld && entityIn instanceof BoatEntity) {
            worldIn.destroyBlock(new BlockPos(pos), true, entityIn);
        }

    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        FluidState fluidstate = worldIn.getFluidState(pos);
        FluidState fluidstate1 = worldIn.getFluidState(pos.up());
        return (fluidstate.getFluid() == Fluids.WATER || state.getMaterial() == Material.ICE) && fluidstate1.getFluid() == Fluids.EMPTY;
    }

    @Override
    public AbstractBlock.OffsetType getOffsetType() {
        return OffsetType.NONE;
    }
}
