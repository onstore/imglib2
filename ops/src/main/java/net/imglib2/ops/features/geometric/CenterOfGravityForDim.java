package net.imglib2.ops.features.geometric;

import net.imglib2.ops.features.AbstractFeature;
import net.imglib2.ops.features.RequiredInput;
import net.imglib2.ops.features.geometric.centerofgravity.CenterOfGravity;
import net.imglib2.type.numeric.real.DoubleType;

public class CenterOfGravityForDim extends AbstractFeature
{
	@RequiredInput
	CenterOfGravity centerOfGravity;

	private final int dim;

	public CenterOfGravityForDim( final int dim )
	{
		this.dim = dim;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String name()
	{
		return "Center of Gravity For Dimension " + dim;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode() + dim;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CenterOfGravityForDim copy()
	{
		return new CenterOfGravityForDim( dim );
	}

	@Override
	public boolean isCompatible( Class< ? > clazz )
	{
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected DoubleType recompute()
	{
		return new DoubleType( centerOfGravity.get()[ dim ] );
	}
}
