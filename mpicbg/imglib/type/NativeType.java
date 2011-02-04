package mpicbg.imglib.type;

import mpicbg.imglib.container.ImgCursor;
import mpicbg.imglib.container.array.Array;
import mpicbg.imglib.container.array.ArrayIterator;
import mpicbg.imglib.container.basictypecontainer.DataAccess;
import mpicbg.imglib.container.cell.Cell;
import mpicbg.imglib.sampler.cell.CellBasicRasterIterator;
import mpicbg.imglib.type.numeric.real.FloatType;

public interface NativeType
{	
	/**
	 * This method is used by the {@link ImgCursor}s to update the data
	 * current data array of the {@link Type}, for example when moving from one
	 * {@link Cell} to the next. If it is only an {@link Array} the
	 * {@link ImgCursor}s never have to call that function.
	 * 
	 * The idea behind this concept is maybe not obvious. The {@link Type} knows
	 * which basic type is used (float, int, byte, ...) but does not know how it
	 * is stored ({@link Array}, {@link CellDirectAccessContainer}, ...) to
	 * prevent multiple implementations of {@link Type}. That's why {@link Type}
	 * asks the {@link DataAccess} to give the actual basic array by passing the
	 * {@link ImgCursor} that calls the method. The {@link DataAccess} is
	 * also an {@link Array}, {@link CellDirectAccessContainer}, ... which can
	 * then communicate with the {@link ArrayIterator},
	 * {@link CellBasicRasterIterator}, ... and return the current basic type
	 * array.
	 * 
	 * A typical implementation of this method looks like that (this is the
	 * {@link FloatType} implementation):
	 * 
	 * float[] v = floatStorage.getCurrentStorageArray( c );
	 * 
	 * @param c
	 *            - the {@link ImgCursor} gives a link to itself so that
	 *            the {@link Type} tell its {@link DataAccess} to get the new
	 *            basic type array.
	 */
	public void updateContainer( Object c );

	/**
	 * Increments the array position of the {@link Type}, this is called by the
	 * {@link ImgCursor}s which iterate over the image.
	 * 
	 * @param i
	 *            - how many steps
	 */
	public void updateIndex( final int i );

	/**
	 * Returns the current index in the storage array, this is called by the
	 * {@link ImgCursor}s which iterate over the image.
	 * 
	 * @return - int index
	 */
	public int getIndex();

	/**
	 * Increases the array index, this is called by the {@link ImgCursor}s
	 * which iterate over the image.
	 */
	public void incIndex();

	/**
	 * Increases the index by increment steps, this is called by the
	 * {@link ImgCursor}s which iterate over the image.
	 * 
	 * @param increment
	 *            - how many steps
	 */
	public void incIndex( final int increment );

	/**
	 * Decreases the array index, this is called by the {@link ImgCursor}s
	 * which iterate over the image.
	 */
	public void decIndex();

	/**
	 * Decreases the index by increment steps, this is called by the
	 * {@link ImgCursor}s which iterate over the image.
	 * 
	 * @param increment
	 *            - how many steps
	 */
	public void decIndex( final int decrement );
	
}
